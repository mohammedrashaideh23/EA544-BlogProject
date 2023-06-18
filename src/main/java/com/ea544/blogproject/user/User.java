package com.ea544.blogproject.user;

import com.ea544.blogproject.comment.Comment;
import com.ea544.blogproject.post.Post;
import com.ea544.blogproject.shared.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "BlogUser")
public class User
        extends BaseEntity {
    @Email
    private String email;
    private String password;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<Post> postList = new ArrayList<>();
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private final List<Comment> commentList = new ArrayList<>();

}
