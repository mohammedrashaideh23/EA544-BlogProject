package com.ea544.blogproject.controller;

import com.ea544.blogproject.Services.PostService;
import com.ea544.blogproject.Services.UserService;
import com.ea544.blogproject.model.dto.PostDto;
import com.ea544.blogproject.model.entity.Post;
import com.ea544.blogproject.model.mapper.PostMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/post")
//@RequiredArgsConstructor
public class PostController {
    private final PostService _postService;
    private final UserService _userService;

    public PostController(PostService postService, UserService userService) {
        _postService = postService;
        _userService = userService;
    }
//    private final PostMapper _postMapper;

    //region Post Actions
    // get all posts
    @GetMapping("")
    public List<PostDto> get() {
        var result = _postService.get();
//        return result;
        return PostMapper.INSTANCE.toDtoList(result);
    }

    // get a post by id
    @GetMapping("/{id}")
    public PostDto get(@PathVariable Integer id) {
        var result = _postService.get(id);
//        return result;
        return PostMapper.INSTANCE.postToPostDto(result);
    }

    // get posts for a certain user
    @GetMapping("/{username}")
    public List<PostDto> getUserPosts(@PathVariable String username) {

        var result = _postService.get(username);
//        return result;
        return PostMapper.INSTANCE.toDtoList(result);
    }

    // create a new post
    @PostMapping("/{username}")
    public void save(@RequestBody Post post,
                     @PathVariable String username) {
        _postService.save(post, username);
    }

    // update post
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id,
                       @RequestBody Post post) {
        _postService.update(id, post);
    }

    //delete a post
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        _postService.delete(id);
    }
    //endregion

    //region Comments actions
    @PostMapping("/action/comment/{postid}/{username}")
    public void addComment(@PathVariable int postid,
                           @PathVariable String username,
                           @RequestBody Map<String, Object> payload) {
        _userService.addComment(postid, username, payload);
    }

    @PutMapping("/action/{username}/comment/{commentId}")
    public void updateComment(@PathVariable int commentId,
                              @PathVariable String username,
                              @RequestBody Map<String, Object> payload) {
        _userService.updateComment(username, commentId, payload);
    }

    @DeleteMapping("/action/{username}/comment/{id}")
    public void deleteComment(@PathVariable String username,
                              @PathVariable int id) {
        _userService.deleteComment(username, id);
    }

    @PostMapping("/action/{postId}/upvote")
    public void upVote(@PathVariable int postId) {
        _postService.vote(postId, Post::upVote);
    }

    @PostMapping("/action/{postId}/downvote")
    public void downVote(@PathVariable int postId) {
        _postService.vote(postId, Post::downVote);
    }

    //endregion

}
