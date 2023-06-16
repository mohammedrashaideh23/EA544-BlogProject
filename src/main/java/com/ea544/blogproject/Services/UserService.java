package com.ea544.blogproject.Services;

import com.ea544.blogproject.Repo.UserRepo;
import com.ea544.blogproject.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService extends BaseService<User, UserRepo> {
    protected UserService(UserRepo userRepo) {
        super(userRepo);
    }
}
