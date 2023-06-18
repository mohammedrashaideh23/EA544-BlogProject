package com.ea544.blogproject.controller;

import com.ea544.blogproject.Services.UserService;
import com.ea544.blogproject.model.dto.EntityUserDto;
import com.ea544.blogproject.model.entity.Post;
import com.ea544.blogproject.model.entity.UserEntity;
import com.ea544.blogproject.model.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    @GetMapping("")
    public List<EntityUserDto> get() {
        var result = _userService.get();
        return UserMapper.INSTANCE.userToUserDto(result);
    }

    @PostMapping("")
    public void save(@RequestBody UserEntity user) {
        _userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        _userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserEntity user) {
        _userService.update(id, user);
    }

    @PostMapping("/action/comment")
    public void addComment(@RequestBody Map<String, Objects> payload) {
        _userService.addComment(payload);
    }

    @PutMapping("/action/comment/{commentId}")
    public void updateComment(@PathVariable int commentId, @RequestBody Map<String, Object> payload) {
        _userService.updateComment(commentId, payload);
    }

    @DeleteMapping("/action/comment/{id}")
    public void deleteComment(@PathVariable int id) {
        _userService.deleteComment(id);
    }

    @PostMapping("/action/{postId}/upvote")
    public void upVote(@PathVariable int postId) {
        _userService.vote(postId, Post::upVote);
    }

    @PostMapping("/action/{postId}/downvote")
    public void downVote(@PathVariable int postId) {
        _userService.vote(postId, Post::downVote);
    }

}
















