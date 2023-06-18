package com.ea544.blogproject.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Table(name = "BlogUser")
public class UserEntity extends BaseEntity {

    //    private String userName;
    @Email
    private String email;
    private String password;
    //    @JsonBackReference
    @OneToMany(mappedBy = "postOwner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Post> postList = new ArrayList<>();
    //    @JsonBackReference
    @OneToMany(mappedBy = "commentOwner", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Comment> commentList = new ArrayList<>();

    @Override
    public String toString() {
        return "User{" +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", postList=" + postList +
                ", commentList=" + commentList +
                '}';
    }

    public String getUsername() {
        if (email != null) {
            return email.split("@")[0];
        }
        return null;
    }

    public void addComment(Comment comment) {
        commentList.add(comment);
    }
}
