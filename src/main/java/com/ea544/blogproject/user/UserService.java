package com.ea544.blogproject.user;

import com.ea544.blogproject.comment.Comment;
import com.ea544.blogproject.comment.CommentRepo;
import com.ea544.blogproject.post.Post;
import com.ea544.blogproject.post.PostRepo;
import com.ea544.blogproject.shared.BaseService;
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

    public void updateComment(Map<String, Object> payload) {
        String content = payload.get("content").toString();
        String username = payload.get("username").toString();
        int commentId = Integer.parseInt(payload.get("commentId").toString());
        Comment comment = _commentRepo.findById(commentId).get();

        if (comment
                .getOwner()
                .getEmail()
                .startsWith(username)) {
            comment.setContent(content);
            _commentRepo.save(comment);
        } else {
            throw new RuntimeException("this comment is not for that user");
        }
    }

    public void deleteComment(Map<String, Object> payload) {
        int postId = Integer.parseInt(extractFromPayload(payload, "postId").toString());
        int commentId = Integer.parseInt(extractFromPayload(payload, "commentId").toString());
        String username = extractFromPayload(payload, "username").toString();
        Comment comment = _commentRepo
                .findByIdAndOwner_EmailStartsWith(commentId, username);
        if (comment != null) {
            _postRepo
                    .findById(postId)
                    .get()
                    .getComments()
                    .remove(comment);
        } else {
            throw new RuntimeException("the user is not owner of this comment");
        }
    }

}




















