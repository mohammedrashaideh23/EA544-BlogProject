package com.ea544.blogproject.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {

    private String title;
    private String description;
    //    @JsonManagedReference
    @ManyToOne
    UserEntity postOwner;
    //    @JsonBackReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Comment> comments = new ArrayList<>();
    //    @JsonBackReference
    @OneToOne(mappedBy = "post")
    Vote vote;

    public void upVote() {
        vote.upVote();
    }

    public void downVote() {
        vote.downVote();
    }

    public String getTitle() {
        return title;
    }

    public Post setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Post setDescription(String description) {
        this.description = description;
        return this;
    }

    public UserEntity getPostOwner() {
        return postOwner;
    }

    public Post setPostOwner(UserEntity postOwner) {
        this.postOwner = postOwner;
        return this;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Post setComments(List<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public Vote getVote() {
        return vote;
    }

    public Post setVote(Vote vote) {
        this.vote = vote;
        return this;
    }
}
