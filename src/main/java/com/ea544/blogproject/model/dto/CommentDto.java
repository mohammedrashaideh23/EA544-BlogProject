package com.ea544.blogproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
//@ToString
public class CommentDto {
    //    private Date created;
    private String owner;
    private String content;

    public String getOwner() {
        return owner;
    }

    public CommentDto setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CommentDto setContent(String content) {
        this.content = content;
        return this;
    }
    //    public String getOwner() {
//        int atIndex = owner.indexOf('@');
//        String username = owner.substring(0, atIndex);
//        return owner;
//    }
}
