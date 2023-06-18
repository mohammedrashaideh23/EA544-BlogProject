package com.ea544.blogproject.model.mapper;

import com.ea544.blogproject.model.dto.CommentDto;
import com.ea544.blogproject.model.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
//        componentModel = "spring"
)
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    //    @Mapping(source = "createdDate", target = "created")
    @Mapping(source = "commentOwner.email", target = "owner")
    CommentDto commentToCommentDto(Comment comment);

    List<CommentDto> toDtoList(List<Comment> commentList);
}
