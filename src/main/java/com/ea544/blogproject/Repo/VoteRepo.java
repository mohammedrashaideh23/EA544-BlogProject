package com.ea544.blogproject.Repo;

import com.ea544.blogproject.model.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepo extends JpaRepository<Vote, Integer> {
}
