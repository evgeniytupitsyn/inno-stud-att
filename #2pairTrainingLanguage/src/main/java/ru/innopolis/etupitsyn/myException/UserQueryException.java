package ru.innopolis.etupitsyn.myException;

/**
 * Created by evgeniytupitsyn on 22.11.2016.
 */
public class UserQueryException extends Exception{

    public static final String LOGIN_ERROR_MESSAGE = "Wrong login/password!";

    public static final String CREATE_ERROR_MESSAGE = "Create user wrong!";

    public UserQueryException(String message) {
        super(message);
    }
}
