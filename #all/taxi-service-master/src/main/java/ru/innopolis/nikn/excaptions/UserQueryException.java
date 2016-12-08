package ru.innopolis.nikn.excaptions;

/**
 * Created by Nikolay on 22.11.2016.
 */
public class UserQueryException extends Exception{

    public static final String LOGIN_ERROR_MESSAGE = "Login or password wrong!";

    public static final String CREATE_ERROR_MESSAGE = "Create user wrong!";



    public UserQueryException(String message) {
        super(message);
    }
}
