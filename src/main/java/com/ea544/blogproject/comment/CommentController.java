package com.ea544.blogproject.comment;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
public class CommentController {

    private final CommentRepo repo;

    public CommentController(CommentRepo repo) {
        this.repo = repo;
    }
//    private final CommentMapper _commentMapper;

    @GetMapping("/{id}")
    public CommentDto get(@PathVariable Integer id) {
        var result = repo.findById(id).orElseThrow();
        return CommentMapper.INSTANCE.commentToCommentDto(result);
    }

    @GetMapping("")
    public List<CommentDto> get() {
        var result = repo.findAll();
        return CommentMapper.INSTANCE.toDtoList(result);
    }

    @PostMapping("")
    public void save(@RequestBody Comment comment) {
        repo.save(comment);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Comment comment, @PathVariable Integer id) {
        if (repo.existsById(id)) {
            repo.findById(id).get().setContent(comment.getContent());
        }
        repo.save(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repo.deleteById(id);

    }

}
