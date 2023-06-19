package com.ea544.blogproject.post;

import com.ea544.blogproject.comment.Comment;
import com.ea544.blogproject.shared.BaseEntity;
import com.ea544.blogproject.user.User;
import com.ea544.blogproject.vote.Vote;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Post
        extends BaseEntity {

    private String title;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    User owner;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<Comment> comments = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private final Vote vote = new Vote();

    public void upVote() {
        vote.upVote();
    }

    public void downVote() {
        vote.downVote();
    }

    public String getUserName() {
        int atIndex = owner.getEmail().indexOf('@');
        return owner.getEmail().substring(0, atIndex);
    }
}
