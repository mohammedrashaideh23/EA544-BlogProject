package com.ea544.blogproject.vote;

import com.ea544.blogproject.shared.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class VoteService extends BaseService<Vote, VoteRepo> {
    protected VoteService(VoteRepo voteRepo) {
        super(voteRepo, Vote.class);
    }
}
