package com.ea544.blogproject.user;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException(String message) {
        super("User: " + message + " not found");
    }
}

