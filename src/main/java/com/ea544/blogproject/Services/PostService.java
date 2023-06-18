package com.ea544.blogproject.Services;

import com.ea544.blogproject.Repo.PostRepo;
import com.ea544.blogproject.Repo.UserRepo;
import com.ea544.blogproject.model.entity.Post;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

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
//        post.setVote(new Vote());
        _repo.save(post);
    }

    public List<Post> get(String username) {
        return _repo.findByOwner_EmailStartsWith(username);
    }

    public void vote(int postId, Consumer<Post> action) {
        Post post = _repo.findById(postId).get();
//        post.setVote(new Vote());
        action.accept(post);
        _repo.save(post);
    }

}
