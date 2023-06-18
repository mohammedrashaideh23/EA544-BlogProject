package com.ea544.blogproject.Repo;

import com.ea544.blogproject.model.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    //    List<Post> findByOwner_EmailStartsWith(String email);
    List<Post> findByPostOwner_EmailStartsWith(String email);

}
