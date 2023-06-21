package com.ea544.blogproject.post;

import com.ea544.blogproject.exception.postNotFoundException;
import com.ea544.blogproject.exception.userNotFoundException;
import com.ea544.blogproject.shared.BaseService;
import com.ea544.blogproject.user.User;
import com.ea544.blogproject.user.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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
        if (user.isPresent()) {
            post.setOwner(user.get());
            _repo.save(post);
        } else {
            throw new userNotFoundException(email);
        }
    }

    public List<Post> get(String username) {
        return _repo.findByOwner_EmailStartsWith(username);
    }

    public void vote(int postId, Consumer<Post> action) {
        Optional<Post> post = _repo.findById(postId);
        if (post.isPresent()) {
            action.accept(post.get());
            _repo.save(post.get());
        } else {
            throw new postNotFoundException(postId);
        }
    }

    public void update(String owner, int postId, Post updatedPost) {
        Optional<Post> persistedPost = _repo.findById(postId);
        if (persistedPost.isPresent()) {
            String persistedOwner = persistedPost.get()
                    .getOwner()
                    .getEmail();
            if (persistedOwner.startsWith(owner)) {
                persistedPost.get().setTitle(updatedPost.getTitle());
                persistedPost.get().setDescription(updatedPost.getDescription());
                _repo.save(persistedPost.get());
            } else {
                throw new userNotFoundException(owner);
            }
        } else {
            throw new postNotFoundException(postId);
        }
    }

    public void deletePost(Map<String, Object> payload) {
        String username = payload.get("username").toString();
        int postId = Integer.parseInt(payload.get("postId").toString());
        Optional<Post> persistedPost = _repo.findById(postId);
        Optional<User> persistedUser = _userRepo.findByEmailStartingWith(username);
        if (persistedPost.isPresent()) {
            if (persistedUser.isPresent()) {
                if (persistedPost.get()
                        .getOwner()
                        .getEmail()
                        .startsWith(username)) {
                    persistedUser.get()
                            .getPostList()
                            .remove(persistedPost.get());
                } else {

                    throw new userNotFoundException(username);
                }
            } else {

                throw new userNotFoundException(username);
            }
        } else {
            throw new postNotFoundException(postId);
        }
    }


}
