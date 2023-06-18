package com.ea544.blogproject.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Integer id;
    private String userName;
    private List<PostDto> postDtoList;
    private List<CommentDto> commentDtoList;
}
