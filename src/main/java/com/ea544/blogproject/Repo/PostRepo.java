package com.ea544.blogproject.Repo;

import com.ea544.blogproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {
}
