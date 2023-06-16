package com.ea544.blogproject.Services;

import com.ea544.blogproject.Repo.PostRepo;
import com.ea544.blogproject.entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PostService extends BaseService<Post, PostRepo> {
    protected PostService(PostRepo postRepo) {
        super(postRepo);
    }
}
