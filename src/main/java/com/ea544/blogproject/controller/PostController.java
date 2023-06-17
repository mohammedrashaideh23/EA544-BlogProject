package com.ea544.blogproject.controller;

import com.ea544.blogproject.Services.PostService;
import com.ea544.blogproject.entity.Comment;
import com.ea544.blogproject.entity.Post;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService _service;

    public PostController(PostService service) {
        _service = service;
    }

    @PostMapping("/{email}")
    public void save(@RequestBody Post post, @PathVariable String email) {

        _service.save(post, email);

    }

    @GetMapping("")
    public List<Post> get() {
        return _service.get();
    }

    @GetMapping("/{id}")
    public Post get(@PathVariable Integer id) {
        return _service.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        _service.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Post post) {
        _service.update(id, post);
    }

    @PostMapping("/comment")
    public void addComment(@RequestBody Map<String, Objects> payload) {
        _service.addComment(payload);
    }


}
