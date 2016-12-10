package com.etupitsyn.chat.util;


public class OpResult {

    public enum Status {
        SUCCESS, FAILURE
    }

    private Status status;
    private String message = null;
    private String data = null;

    public OpResult(Status status, String message, String data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public OpResult(Status status, String message) {
        this.status = status;
        this.message = message;
    }

    public OpResult(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("status = %s message = %s data = %s",
                status, message, data);
    }

}
