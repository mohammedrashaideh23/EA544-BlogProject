package com.ea544.blogproject.Services;

import com.ea544.blogproject.Repo.CommentRepo;
import com.ea544.blogproject.Repo.PostRepo;
import com.ea544.blogproject.Repo.UserRepo;
import com.ea544.blogproject.model.entity.Comment;
import com.ea544.blogproject.model.entity.Post;
import com.ea544.blogproject.model.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Map;

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

    private static Comment createComment(String tempContent, User owner, Post post) {
        Comment comment = new Comment();
        comment.setPost(post);
        comment.setOwner(owner);
        comment.setContent(tempContent);
        return comment;
    }

    public void addComment(int postId,
                           String username,
                           Map<String, Object> payload) {
        String tempContent = extractFromPayload(payload,
                "content")
                .toString();
        User owner = _repo
                .findByEmailStartingWith(username);
        Post post = _postRepo
                .findById(postId)
                .orElseThrow();
        _commentRepo.save(createComment(tempContent, owner, post));
    }

    public Object extractFromPayload(Map<String, Object> payload,
                                     String element) {

        return payload.get(element);

    }

    public void updateComment(String username, int id, Map<String, Object> payload) {
        String content = payload.get("content").toString();
        Comment comment = _commentRepo.findById(id).get();

        if (comment.getOwner().getEmail().startsWith(username)) {
            comment.setContent(content);
            _commentRepo.save(comment);
        } else {
            throw new RuntimeException("this comment is not for that user");
        }
    }

    public void deleteComment(String username, int id) {
        if (_commentRepo.findById(id).get().getOwner().getEmail().startsWith(username)) {
            _commentRepo.deleteById(id);
        } else {
            throw new RuntimeException("the user is not owner of this comment");
        }
    }

}




















