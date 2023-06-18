package com.ea544.blogproject.comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
//    Boolean ExistsAndByOwnerEmailStartsWith(int id, String username);
//    boolean existsById_existsByOwnerEmailStartsWith(int id, String username);
//    Comment findByOwnerEmailStartsWith(String username);

    Comment findByIdAndOwner_EmailStartsWith(Integer id, String email);


}
