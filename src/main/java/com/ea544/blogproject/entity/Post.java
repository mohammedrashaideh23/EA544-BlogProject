package com.ea544.blogproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {

    private String title;
    private String description;
    //    @JsonManagedReference
    @ManyToOne
    User owner;
    //    @JsonBackReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    List<Comment> commentList = new ArrayList<>();
    //    @JsonBackReference
    @OneToOne(mappedBy = "post")
    Vote vote;

    public void upVote() {
        vote.upVote();
    }

    public void downVote() {
        vote.downVote();
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + getId() +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", commentList=" + commentList +
                ", vote=" + vote +
                '}';
    }
}
