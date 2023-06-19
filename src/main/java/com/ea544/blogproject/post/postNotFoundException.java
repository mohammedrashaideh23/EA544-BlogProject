package com.ea544.blogproject.post;

public class postNotFoundException extends RuntimeException {
    public postNotFoundException() {
        super("Post not found");
    }
}

