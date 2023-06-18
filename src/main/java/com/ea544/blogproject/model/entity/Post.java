package com.ea544.blogproject.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
//@NoArgsConstructor
public class Post
        extends BaseEntity {

    private String title;
    private String description;
    @ManyToOne(cascade = CascadeType.PERSIST)
    User owner;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comment> comments = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    private Vote vote = new Vote();

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
