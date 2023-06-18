package com.ea544.blogproject.Services;

import com.ea544.blogproject.Repo.CommentRepo;
import com.ea544.blogproject.Repo.PostRepo;
import com.ea544.blogproject.Repo.UserRepo;
import com.ea544.blogproject.model.entity.Comment;
import com.ea544.blogproject.model.entity.Post;
import com.ea544.blogproject.model.entity.UserEntity;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@Transactional
public class UserService extends BaseService<UserEntity, UserRepo> {
    private final PostRepo _postRepo;
    private final CommentRepo _commentRepo;

    protected UserService(UserRepo userRepo, PostRepo postRepo, CommentRepo commentRepo) {
        super(userRepo, UserEntity.class);
        _postRepo = postRepo;
        _commentRepo = commentRepo;
    }

    public void addComment(Map<String, Objects> payload) {
        Integer tempPostId = Integer.parseInt(payload.get("postid").toString());
        String tempUserName = payload.get("username").toString();
        String tempComment = payload.get("comment").toString();
        UserEntity owner = _repo.findByEmailStartingWith(tempUserName);
        Post post = _postRepo.findById(tempPostId).orElseThrow();
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setCommentOwner(owner);
        _commentRepo.save(comment);
    }

    public void updateComment(int id, Map<String, Object> payload) {
        String content = payload.get("content").toString();
        Optional<Comment> optComment = _commentRepo.findById(id);
        if (optComment.isPresent()) {
            Comment comment = optComment.get();
            comment.setContent(content);
            _commentRepo.save(comment);
        } else {
            throw new EntityNotFoundException("this comment doesnt exist");
        }
    }

    public void deleteComment(int id) {
        _commentRepo.deleteById(id);
    }

    public void vote(int postId, Consumer<Post> action) {
        Post post = _postRepo.findById(postId).get();
        action.accept(post);
        _postRepo.save(post);
    }
}




















