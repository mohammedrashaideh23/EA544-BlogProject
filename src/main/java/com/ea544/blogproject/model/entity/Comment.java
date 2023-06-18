package com.ea544.blogproject.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "Comment{" +
                "content='" + content + '\'' +
                '}';
    }
}
