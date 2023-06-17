package com.ea544.blogproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @ManyToOne
    User owner;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    List<Comment> commentList = new ArrayList<>();
    @OneToOne
    Vote vote;


    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", commentList=" + commentList +
                ", vote=" + vote +
                '}';
    }
}
