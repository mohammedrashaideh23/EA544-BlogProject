package com.ea544.blogproject.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByEmailStartingWith(String username);

    boolean existsUserByEmailStartingWith(String username);

}
