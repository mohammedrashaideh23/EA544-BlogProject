package com.ea544.blogproject.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CommentDto {
    //    private Date created;
    private String owner;
    private String content;

//    public String getOwner() {
//        int atIndex = owner.indexOf('@');
//        String username = owner.substring(0, atIndex);
//        return owner;
//    }
}
