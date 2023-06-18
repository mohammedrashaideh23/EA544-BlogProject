package com.ea544.blogproject.model.mapper;

import com.ea544.blogproject.model.dto.EntityUserDto;
import com.ea544.blogproject.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {PostMapper.class, CommentMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "userName", source = "email")
    @Mapping(target = "postDtoList", source = "postList")
    @Mapping(target = "commentDtoList", source = "commentList")
    EntityUserDto userToUserDto(UserEntity user);

    List<EntityUserDto> userToUserDto(List<UserEntity> userList);
}
