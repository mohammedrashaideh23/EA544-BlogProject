package com.ea544.blogproject.post;

import com.ea544.blogproject.comment.CommentService;
import com.ea544.blogproject.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/post")
//@RequiredArgsConstructor
public class PostController {
    private final PostService _postService;
    private final UserService _userService;
    private final CommentService _commentService;

    public PostController(PostService postService,
                          UserService userService, CommentService commentService) {
        _postService = postService;
        _userService = userService;
        _commentService = commentService;
    }

    //region Post Actions
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
    public void save(@RequestBody Post post,
                     @PathVariable String username) {
        _postService.save(post,
                username);
    }

    // update post
    @PutMapping("/{username}/{postId}")
    public void update(@PathVariable String username, @PathVariable Integer postId,
                       @RequestBody Post post) {
        _postService.update(username, postId,
                post);
    }

    //delete a post
    @DeleteMapping("")
    public void delete(@RequestBody Map<String, Object> payload) {
        _postService.deletePost(payload);
    }
    //endregion

    //region Comments actions
    @PostMapping("/action/comment/{postid}/{username}")
    public void addComment(@PathVariable int postid,
                           @PathVariable String username,
                           @RequestBody Map<String, Object> payload) {
        _commentService.addComment(postid,
                username,
                payload);
    }

    @PutMapping("/action/comment")
    public void updateComment(
            @RequestBody Map<String, Object> payload) {
        _commentService.updateComment(payload);
    }

    @DeleteMapping("/action/comment")
    public void deleteComment(@RequestBody Map<String,
            Object> payload) {
        _commentService.deleteComment(payload);
    }

    @PostMapping("/action/{postId}/upvote")
    public void upVote(@PathVariable int postId) {
        _postService.vote(postId,
                Post::upVote);
    }

    @PostMapping("/action/{postId}/downvote")
    public void downVote(@PathVariable int postId) {
        _postService.vote(postId,
                Post::downVote);
    }

    //endregion

}
