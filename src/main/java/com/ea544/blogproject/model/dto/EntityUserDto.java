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
public class EntityUserDto {
    private String userName;
    private List<PostDto> postDtoList;
    private List<CommentDto> commentDtoList;

//    public String getUserName() {
//        int atIndex = userName.indexOf('@');
//        String username = userName.substring(0, atIndex);
//        return userName;
//    }
}
