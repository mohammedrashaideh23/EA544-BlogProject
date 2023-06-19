package com.ea544.blogproject.comment;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    //    @Mapping(source = "createdDate", target = "created")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "owner")
    CommentDto commentToCommentDto(Comment comment);

    List<CommentDto> toDtoList(List<Comment> commentList);
}
