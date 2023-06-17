package com.ea544.blogproject.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Comment extends BaseEntity {

    private String content;
    private boolean isDeleted;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User owner;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Post post;

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
