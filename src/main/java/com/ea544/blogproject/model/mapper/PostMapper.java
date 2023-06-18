package com.ea544.blogproject.model.mapper;

import com.ea544.blogproject.model.dto.PostDto;
import com.ea544.blogproject.model.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {UserMapper.class, CommentMapper.class})
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    //    @Mapping( source = "createdDate", target = "created")
    @Mapping(source = "postOwner.email", target = "owner")
    @Mapping(source = "vote.voteCount", target = "votes")
    PostDto postToPostDto(Post post);

    List<PostDto> toDtoList(List<Post> postList);
}
