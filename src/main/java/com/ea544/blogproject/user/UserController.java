package com.ea544.blogproject.user;

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
    public List<UserDto> get() {
        var result = _userService.get();
        return UserMapper.INSTANCE.toUserDtoList(result);
    }

    @GetMapping("/{id}")
    public UserDto get(@PathVariable int id) {
        var result = _userService.get(id);
        return UserMapper.INSTANCE.toUserDto(result);
    }

    @PostMapping("")
    public void save(@RequestBody User user) {
        _userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        _userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody User user) {
        _userService.update(id, user);
    }



}

















