package com.ea544.blogproject.controller;

import com.ea544.blogproject.Services.UserService;
import com.ea544.blogproject.model.dto.UserEntityDto;
import com.ea544.blogproject.model.entity.UserEntity;
import com.ea544.blogproject.model.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
//@RequiredArgsConstructor
public class UserController {

    private final UserService _userService;

    public UserController(UserService userService) {
        _userService = userService;
    }

    //    private final UserMapper _userMapper;
    @GetMapping("")
    public List<UserEntityDto> get() {
        var result = _userService.get();
        return UserMapper.INSTANCE.userToUserDto(result);
    }

    @PostMapping("")
    public void save(@RequestBody UserEntity user) {
        _userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        _userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody UserEntity user) {
        _userService.update(id, user);
    }



}

















