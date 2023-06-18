package com.ea544.blogproject.controller;

import com.ea544.blogproject.Services.PostService;
import com.ea544.blogproject.model.dto.PostDto;
import com.ea544.blogproject.model.entity.Post;
import com.ea544.blogproject.model.mapper.PostMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
//@RequiredArgsConstructor
public class PostController {
    private final PostService _postService;

    public PostController(PostService postService) {
        _postService = postService;
    }
//    private final PostMapper _postMapper;

    // get all posts
    @GetMapping("")
    public List<PostDto> get() {
        var result = _postService.get();
        return PostMapper.INSTANCE.toDtoList(result);
    }

    // get a post by id
    @GetMapping("/{id}")
    public PostDto get(@PathVariable Integer id) {
        var result = _postService.get(id);

        return PostMapper.INSTANCE.postToPostDto(result);
    }

    // get posts for a certain user
    @GetMapping("/{username}")
    public List<PostDto> getUserPosts(@PathVariable String username) {

        var result = _postService.get(username);
        return PostMapper.INSTANCE.toDtoList(result);
    }

    // create a new post
    @PostMapping("/{username}")
    public void save(@RequestBody Post post, @PathVariable String username) {
        _postService.save(post, username);
    }

    // update post
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody Post post) {
        _postService.update(id, post);
    }

    //delete a post
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        _postService.delete(id);
    }

}
