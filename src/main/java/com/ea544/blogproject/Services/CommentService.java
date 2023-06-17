package com.ea544.blogproject.Services;

import com.ea544.blogproject.Repo.CommentRepo;
import com.ea544.blogproject.entity.Comment;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommentService extends BaseService<Comment, CommentRepo> {
    protected CommentService(CommentRepo commentRepo) {
        super(commentRepo, Comment.class);
    }

}
