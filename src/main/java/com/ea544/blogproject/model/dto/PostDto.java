package com.ea544.blogproject.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostDto {
    //    private Date created;
    private Integer id;
    private String owner;
    private String title;
    private String description;
    private List<CommentDto> comments;
    private int votes;
}
