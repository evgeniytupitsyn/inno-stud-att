package ru.innopolis.uni.course2.objectpool;

/**
 * Created by evgeniytupitsyn on 07/11/2016.
 */


import com.sun.istack.internal.Pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPool<T> implements Pool<T> {
    public enum PoolState {
        STARTING, STARTED, STOPPING, STOPPED
    }

    private PoolState currentStatus;
    private BlockingQueue<T> pool = new LinkedBlockingQueue<>();
    private int pollTimeout;
    private int poolSize;

    protected AbstractPool() {
        this.poolSize = 100;
        initialize();
    }

    protected AbstractPool(int poolSize) {
        this.poolSize = poolSize;
        initialize();
    }

    protected AbstractPool(int poolSize, int pollTimeout) {
        this.pollTimeout = pollTimeout;
        this.poolSize = poolSize;
        initialize();
    }


    /**
     * Initialise the pool and populate it with poolSize number of objects
     */
    private void initialize() {
        updatePoolStatus(PoolState.STARTING);
        if (poolSize < 1) {
            throw new IllegalArgumentException("Pool Size must be at least 1");
        }
        while (pool.size() < poolSize) {
            pool.add(createObject());
        }
        updatePoolStatus(PoolState.STARTED);
    }

    /**
     * Sets the pools current status
     *
     * @param currentStatus the pool's current status
     */
    private void updatePoolStatus(PoolState currentStatus) {
        this.currentStatus = currentStatus;
    }


    /**
     * Returns the current pool size
     *
     * @return number of objects in the pool
     */
    public int getCurrentPoolSize() {
        return pool.size();
    }

    /**
     * Is the pool null
     *
     * @return true if null otherwise false
     */
    public boolean isPoolNull() {
        return pool == null;
    }


    /**
     * Returns the status of the current pool.
     *
     * @return the current pool status
     */
    public PoolState poolState() {
        return this.currentStatus;
    }


    /**
     * Gets the next free object from the pool.
     * <p/>
     * Different strategies can be implemented to deal with a
     * situation where the pool doesn't contain any objects.
     * <p/>
     * Some possible options:
     * <p/>
     * 1. a new object will be created and given to the caller of this method.
     * 2. a PoolDepletionException is thrown
     * 3. wait for a specified time for an object to be returned
     *
     * @return T borrowed object
     * @throws PoolDepletionException thrown if the pool has been depleted
     * @throws InterruptedException
     */
    public T acquire() throws Exception, PoolDepletionException {
        checkPoolStatus();
        T t = pool.poll(pollTimeout, TimeUnit.MILLISECONDS);

        if (t == null) {
            throw new PoolDepletionException("The pool is empty and was not replenished within timeout limits.");
        }

        return t;
    }


    /**
     * Returns object back to the pool.
     * <p/>
     * Possible implementation may include code to clean/reset the
     * object to initial values.
     *
     * @param object object to be returned
     */
    public void surrender(T object) throws Exception {
        checkPoolStatus();
        if (object == null) {
            return;
        }
        this.pool.offer(object);
    }


    /**
     * Creates a new object.
     *
     * @return T new object
     */
    protected abstract T createObject();


    /**
     * Adds object to the pool.
     *
     * @return true if added successfully otherwise false
     */
    public boolean add() throws Exception {
        checkPoolStatus();
        return pool.add(createObject());
    }


    /**
     * Checks that the pool is running and ready for use otherwise it throws an exception
     *
     * @throws Exception thrown if pool not ready or shutting down
     */
    private void checkPoolStatus() throws Exception {
        if (poolState() != PoolState.STARTED) throw new Exception("Pool not ready or stopped");
    }

    /**
     * Destroys an object.
     */
    public void destroy() {
        pool.poll();
    }


    /**
     * Destroys the entire pool.
     */
    public void destroyPool() {
        updatePoolStatus(PoolState.STOPPING);
        while (pool != null && !pool.isEmpty()) {
            destroy();
        }
        pool = null;
        updatePoolStatus(PoolState.STOPPED);
    }
}
