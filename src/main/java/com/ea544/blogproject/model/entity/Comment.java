package com.ea544.blogproject.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Comment extends
        BaseEntity {
    private String content;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private User owner;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Post post;

    public String getUserName() {
        int atIndex = owner.getEmail().indexOf('@');
        return owner.getEmail().substring(0, atIndex);
    }
}
