package com.ea544.blogproject.comment;

import com.ea544.blogproject.shared.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommentService extends BaseService<Comment, CommentRepo> {
    protected CommentService(CommentRepo commentRepo) {
        super(commentRepo, Comment.class);
    }
}
