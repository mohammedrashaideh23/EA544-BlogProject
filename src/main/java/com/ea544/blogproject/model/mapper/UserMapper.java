package com.ea544.blogproject.model.mapper;

import com.ea544.blogproject.model.dto.UserEntityDto;
import com.ea544.blogproject.model.entity.UserEntity;
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

    @Mapping(target = "userName", source = "email")
    @Mapping(target = "postDtoList", source = "postList")
    @Mapping(target = "commentDtoList", source = "commentList")
    UserEntityDto userToUserDto(UserEntity user);

    List<UserEntityDto> userToUserDto(List<UserEntity> userList);
}
