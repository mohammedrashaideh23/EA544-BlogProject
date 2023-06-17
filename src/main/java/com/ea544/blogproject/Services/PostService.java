package com.ea544.blogproject.Services;

import com.ea544.blogproject.Repo.PostRepo;
import com.ea544.blogproject.Repo.UserRepo;
import com.ea544.blogproject.entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostService extends BaseService<Post, PostRepo> {
    private final UserRepo _userRepo;

    protected PostService(PostRepo postRepo, UserRepo userRepo) {

        super(postRepo, Post.class);
        this._userRepo = userRepo;
    }

    public void save(Post post, String email) {
        var user = _userRepo.findByEmailStartingWith(email);
        post.setOwner(user);
        _repo.save(post);
    }

    public List<Post> get(String username) {
        return _repo.findByOwner_EmailStartsWith(username);
    }
}
