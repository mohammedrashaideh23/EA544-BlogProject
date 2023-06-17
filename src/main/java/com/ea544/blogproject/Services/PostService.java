package com.ea544.blogproject.Services;

import com.ea544.blogproject.Repo.CommentRepo;
import com.ea544.blogproject.Repo.PostRepo;
import com.ea544.blogproject.Repo.UserRepo;
import com.ea544.blogproject.entity.Comment;
import com.ea544.blogproject.entity.Post;
import com.ea544.blogproject.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
@Transactional
public class PostService extends BaseService<Post, PostRepo> {
    private final UserRepo userRepo;
    private final CommentRepo commentRepo;


    protected PostService(PostRepo postRepo, UserRepo userRepo, CommentRepo commentRepo) {

        super(postRepo);
        this.userRepo = userRepo;
        this.commentRepo = commentRepo;
    }

    public void save(Post post, String email) {
        var user = userRepo.findByEmail(email);
        if (user.isPresent()) {
            post.setOwner(user.get());
            _repo.save(post);
        } else {
            throw new EntityNotFoundException("This User  : " + email + " is not an existing user ");
        }

    }
    public void addComment(Map<String, Objects> payload){
        Integer postId = Integer.parseInt(payload.get("postid").toString());
        String  userName =payload.get("username").toString();
        String  comment=payload.get("comment").toString();
        User owner=userRepo.findByEmail(userName).orElseThrow();
        Post post=_repo.findById(postId).orElseThrow();
        Comment comment1=new Comment();
        comment1.setContent(comment);
        comment1.setPost(post);
        comment1.setOwner(owner);
        commentRepo.save(comment1);


    }


}
