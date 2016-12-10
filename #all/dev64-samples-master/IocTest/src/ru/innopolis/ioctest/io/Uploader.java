package ru.innopolis.ioctest.io;

/**
 * Created by evgeniytupitsyn on 24/11/2016.
 */
public interface Uploader {

    /**
     *
     * @param path
     * @param content
     * @return
     */
    public boolean upload(String path, Object content);
}
