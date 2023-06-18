package com.ea544.blogproject.post;

import com.ea544.blogproject.shared.BaseService;
import com.ea544.blogproject.user.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
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

    public void deletePost(Map<String, Object> payload) {
        String username = payload.get("username").toString();
        int postId = Integer.parseInt(payload.get("postId").toString());
        Post post = _repo.findById(postId).get();
        if (post
                .getOwner()
                .getEmail()
                .startsWith(username)) {
            _userRepo.findByEmailStartingWith(username)
                    .getPostList()
                    .remove(post);
        } else {

            throw new EntityNotFoundException("Not found");
        }
    }


}
