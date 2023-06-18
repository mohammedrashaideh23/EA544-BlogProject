package com.ea544.blogproject.Repo;

import com.ea544.blogproject.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmailStartingWith(String username);

}
