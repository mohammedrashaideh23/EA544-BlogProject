package com.ea544.blogproject.exception;

public class postNotFoundException extends RuntimeException {
    public postNotFoundException(int message) {
        super("Post: " + message + "  not found");
    }
}

