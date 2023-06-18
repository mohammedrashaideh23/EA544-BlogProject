package com.ea544.blogproject.model.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

//@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
//@ToString
public class UserEntityDto {
    private String userName;
    private List<PostDto> postDtoList;
    private List<CommentDto> commentDtoList;

    public String getUserName() {
        return userName;
    }

    public UserEntityDto setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public List<PostDto> getPostDtoList() {
        return postDtoList;
    }

    public UserEntityDto setPostDtoList(List<PostDto> postDtoList) {
        this.postDtoList = postDtoList;
        return this;
    }

    public List<CommentDto> getCommentDtoList() {
        return commentDtoList;
    }

    public UserEntityDto setCommentDtoList(List<CommentDto> commentDtoList) {
        this.commentDtoList = commentDtoList;
        return this;
    }

    //    public String getUserName() {
//        int atIndex = userName.indexOf('@');
//        String username = userName.substring(0, atIndex);
//        return userName;
//    }
}
