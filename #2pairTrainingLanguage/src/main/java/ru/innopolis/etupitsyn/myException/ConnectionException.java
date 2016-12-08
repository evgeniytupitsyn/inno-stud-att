package ru.innopolis.etupitsyn.myException;

/**
 * Created by evgeniytupitsyn on 22.11.2016.
 */
public class ConnectionException  extends Exception{

    private static final String DEFAULT_MESSAGE = "Connection refused";

    public ConnectionException(String message) {
        super(message);
    }

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }
}
