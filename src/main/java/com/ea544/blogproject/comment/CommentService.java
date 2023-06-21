package com.ea544.blogproject.comment;

import com.ea544.blogproject.exception.commentNotFoundException;
import com.ea544.blogproject.exception.postNotFoundException;
import com.ea544.blogproject.exception.userNotFoundException;
import com.ea544.blogproject.post.Post;
import com.ea544.blogproject.post.PostRepo;
import com.ea544.blogproject.shared.BaseService;
import com.ea544.blogproject.user.User;
import com.ea544.blogproject.user.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class CommentService extends BaseService<Comment, CommentRepo> {
    private final PostRepo _postRepo;
    private final UserRepo _userRepo;

    protected CommentService(CommentRepo commentRepo, PostRepo postRepo, UserRepo userRepo) {
        super(commentRepo, Comment.class);
        _postRepo = postRepo;
        _userRepo = userRepo;
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
        Optional<User> owner = _userRepo
                .findByEmailStartingWith(username);
        Optional<Post> post = _postRepo
                .findById(postId);

        if (post.isPresent()) {
            if (owner.isPresent()) {
                _repo.save(createComment(tempContent, owner.get(), post.get()));
            } else {
                throw new userNotFoundException(username);
            }
        } else {
            throw new postNotFoundException(postId);
        }
    }

    public Object extractFromPayload(Map<String, Object> payload,
                                     String element) {
        return payload.get(element);

    }

    public void updateComment(Map<String, Object> payload) {
        String content = payload.get("content").toString();
        String username = payload.get("username").toString();
        int commentId = Integer.parseInt(payload.get("commentId").toString());
        Optional<Comment> comment = _repo.findById(commentId);
        if (comment.isPresent()) {
            if (comment
                    .get()
                    .getOwner()
                    .getEmail()
                    .startsWith(username)) {
                comment.get().setContent(content);
                _repo.save(comment.get());
            } else {
                throw new userNotFoundException(username);
            }
        } else {
            throw new commentNotFoundException(commentId);
        }
    }

    public void deleteComment(Map<String, Object> payload) {
        int postId = Integer.parseInt(extractFromPayload(payload, "postId").toString());
        int commentId = Integer.parseInt(extractFromPayload(payload, "commentId").toString());
        String username = extractFromPayload(payload, "username").toString();
        Comment comment = _repo
                .findByIdAndOwner_EmailStartsWith(commentId, username);
        Optional<Post> persistedPost = _postRepo.findById(postId);
        if (persistedPost.isPresent()) {
            if (comment != null) {
                persistedPost
                        .get()
                        .getComments()
                        .remove(comment);
            } else {
                throw new userNotFoundException(username);
            }
        } else {
            throw new postNotFoundException(postId);
        }
    }
}
