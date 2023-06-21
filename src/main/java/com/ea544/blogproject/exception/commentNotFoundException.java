package com.ea544.blogproject.exception;

public class commentNotFoundException extends RuntimeException {
    public commentNotFoundException(int message) {
        super("Comment: " + message + "  not found");
    }
}

