package com.ea544.blogproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
//@ToString
public class PostDto {
    //    private Date created;
    private String owner;
    private String title;
    private String description;
    private List<CommentDto> comments;
    private int votes;

    public String getOwner() {
        return owner;
    }

    public PostDto setOwner(String owner) {
        this.owner = owner;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PostDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public PostDto setComments(List<CommentDto> comments) {
        this.comments = comments;
        return this;
    }

    public int getVotes() {
        return votes;
    }

    public PostDto setVotes(int votes) {
        this.votes = votes;
        return this;
    }
    //    public String getOwner() {
//        int atIndex = owner.indexOf('@');
//        String username = owner.substring(0, atIndex);
//        return owner;
//    }
}
