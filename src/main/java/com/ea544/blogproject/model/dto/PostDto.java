package com.ea544.blogproject.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDto {
    //    private Date created;
    private String owner;
    private String title;
    private String description;
    private List<CommentDto> comments;
    private int votes;
//    public String getOwner() {
//        int atIndex = owner.indexOf('@');
//        String username = owner.substring(0, atIndex);
//        return owner;
//    }
}
