package com.ea544.blogproject.user;

import com.ea544.blogproject.comment.CommentRepo;
import com.ea544.blogproject.post.PostRepo;
import com.ea544.blogproject.shared.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService extends BaseService<User, UserRepo> {
    private final PostRepo _postRepo;
    private final CommentRepo _commentRepo;

    protected UserService(UserRepo userRepo, PostRepo postRepo, CommentRepo commentRepo) {
        super(userRepo, User.class);
        _postRepo = postRepo;
        _commentRepo = commentRepo;
    }



}




















