package com.example.autodealer.controller;


import com.example.autodealer.entity.User;
import com.example.autodealer.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user) {
        return  userService.addUser(user);
    }

    @GetMapping("/get")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }



}
