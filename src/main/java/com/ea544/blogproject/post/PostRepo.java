package com.ea544.blogproject.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {
    
    List<Post> findByOwner_EmailStartsWith(String email);
}
