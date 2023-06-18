package com.ea544.blogproject.model.mapper;

import com.ea544.blogproject.model.dto.UserDto;
import com.ea544.blogproject.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
//        componentModel = "spring",
        uses = {PostMapper.class, CommentMapper.class})
//@Component
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(target = "userName", source = "email")
    @Mapping(target = "postDtoList", source = "postList")
    @Mapping(target = "commentDtoList", source = "commentList")
    UserDto userToUserDto(User user);

    List<UserDto> userToUserDto(List<User> userList);
}
