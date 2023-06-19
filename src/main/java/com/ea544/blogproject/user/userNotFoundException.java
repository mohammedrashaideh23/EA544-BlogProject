package com.ea544.blogproject.user;

public class userNotFoundException extends RuntimeException {
    public userNotFoundException() {
        super("User not found");
    }
}

