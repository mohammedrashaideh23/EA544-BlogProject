package com.ea544.blogproject.comment;

import lombok.Data;

@Data
public class CommentDto {
    //    private Date created;
    private Integer id;
    private String owner;
    private String content;
}
