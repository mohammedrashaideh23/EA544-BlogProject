package com.ea544.blogproject.Repo;

import com.ea544.blogproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {


}
