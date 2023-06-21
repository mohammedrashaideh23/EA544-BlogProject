package com.ea544.blogproject.user;

import com.ea544.blogproject.comment.CommentMapper;
import com.ea544.blogproject.post.PostMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {PostMapper.class, CommentMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "userName", source = "email")
    @Mapping(target = "posts", source = "postList")
    UserDto toUserDto(User user);

    List<UserDto> toUserDtoList(List<User> userList);
}
