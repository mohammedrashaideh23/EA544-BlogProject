package com.ea544.blogproject.controller;

import com.ea544.blogproject.Services.PostService;
import com.ea544.blogproject.entity.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService _postService;

    public PostController(PostService service) {
        _postService = service;
    }

    // create a new post
    @PostMapping("/{username}")
    public void save(@RequestBody Post post, @PathVariable String username) {
        _postService.save(post, username);
    }

    // get all posts
    @GetMapping("")
    public List<Post> get() {
        return _postService.get();
    }

    // get a post by id
    @GetMapping("/{id}")
    public Post get(@PathVariable Integer id) {
        return _postService.get(id);
    }

    // get posts for a certain user
    @GetMapping("/{username}")
    public List<Post> getUserPosts(@PathVariable String username) {
        return _postService.get(username);
    }

    //delete a post
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        _postService.delete(id);
    }

    // update a post
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Post post) {
        _postService.update(id, post);
    }


}
