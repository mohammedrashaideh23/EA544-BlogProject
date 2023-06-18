package com.ea544.blogproject.vote;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepo extends JpaRepository<Vote, Integer> {
}
