package com.ea544.blogproject.exception;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(String message) {
        super("User: " + message + " not found");
    }
}

