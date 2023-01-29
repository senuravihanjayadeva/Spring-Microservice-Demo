package com.springmicroservicedemo.userservice.controller;

import com.springmicroservicedemo.userservice.dto.ResponseTemplateUser;
import com.springmicroservicedemo.userservice.entity.User;
import com.springmicroservicedemo.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        log.info("Inside the saveUser in Controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{userId}")
    public ResponseTemplateUser getUserWithDepartment(@PathVariable Long userId){
        log.info("Inside the getUserWithDepartment in Controller");
        return userService.getUserWithDepartment(userId);
    }
}
