package com.ea544.blogproject.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@Entity
@Table(name = "BlogUser")
public class UserEntity extends BaseEntity {

    //    private String userName;
    @Email
    private String email;
    private String password;
    //    @JsonBackReference
    @OneToMany(mappedBy = "postOwner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Post> postList = new ArrayList<>();
    //    @JsonBackReference
    @OneToMany(mappedBy = "commentOwner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comment> commentList = new ArrayList<>();

    public void addComment(Comment comment) {
        commentList.add(comment);
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public UserEntity setPostList(List<Post> postList) {
        this.postList = postList;
        return this;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public UserEntity setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
        return this;
    }
}
