package com.ea544.blogproject.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comment extends BaseEntity {

    private String content;
    //    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserEntity commentOwner;
    //    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Post post;

    public String getContent() {
        return content;
    }

    public Comment setContent(String content) {
        this.content = content;
        return this;
    }

    public UserEntity getCommentOwner() {
        return commentOwner;
    }

    public Comment setCommentOwner(UserEntity commentOwner) {
        this.commentOwner = commentOwner;
        return this;
    }

    public Post getPost() {
        return post;
    }

    public Comment setPost(Post post) {
        this.post = post;
        return this;
    }
}
