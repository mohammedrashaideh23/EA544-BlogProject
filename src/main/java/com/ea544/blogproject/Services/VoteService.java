package com.ea544.blogproject.Services;

import com.ea544.blogproject.Repo.VoteRepo;
import com.ea544.blogproject.entity.Vote;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VoteService extends BaseService<Vote, VoteRepo> {
    protected VoteService(VoteRepo voteRepo) {
        super(voteRepo, Vote.class);
    }
}
