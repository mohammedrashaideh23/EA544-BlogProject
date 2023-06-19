package com.ea544.blogproject.comment;

public class commentNotFoundException extends RuntimeException {
    public commentNotFoundException() {
        super("Comment not found");
    }
}

