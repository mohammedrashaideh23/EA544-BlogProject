package com.ea544.blogproject.post;

public class postNotFoundException extends RuntimeException {
    public postNotFoundException(int message) {
        super("Post: " + message + "  not found");
    }
}

