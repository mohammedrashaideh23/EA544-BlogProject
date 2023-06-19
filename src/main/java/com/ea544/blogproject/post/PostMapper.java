package com.ea544.blogproject.post;

import com.ea544.blogproject.comment.CommentMapper;
import com.ea544.blogproject.user.UserMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {UserMapper.class, CommentMapper.class})
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userName", target = "owner")
    @Mapping(source = "vote.voteCount", target = "votes")
    PostDto postToPostDto(Post post);

    List<PostDto> toDtoList(List<Post> postList);
}
