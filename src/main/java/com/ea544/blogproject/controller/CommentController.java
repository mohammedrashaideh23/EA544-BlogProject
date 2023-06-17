package com.ea544.blogproject.controller;

import com.ea544.blogproject.Repo.CommentRepo;
import com.ea544.blogproject.entity.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController implements BaseController<Comment> {

    private final CommentRepo repo;

    public CommentController(CommentRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    @Override
    public Comment get(@PathVariable Integer id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping("")
    @Override
    public List<Comment> get() {
        return repo.findAll();
    }

    @PutMapping("/{id}")
    @Override
    public void update(@RequestBody Comment comment, @PathVariable Integer id) {
        if (repo.existsById(id)) {
            repo.findById(id).get().setContent(comment.getContent());
        }
        repo.save(comment);

    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);

    }

    @PostMapping("")
    @Override
    public void save(@RequestBody Comment entity) {
        repo.save(entity);


    }
}
