package com.ea544.blogproject.user;

import com.ea544.blogproject.post.PostDto;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Integer id;
    private String userName;
    private List<PostDto> posts;
}
