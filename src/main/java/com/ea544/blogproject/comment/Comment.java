package com.ea544.blogproject.comment;

import com.ea544.blogproject.post.Post;
import com.ea544.blogproject.shared.BaseEntity;
import com.ea544.blogproject.user.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
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
