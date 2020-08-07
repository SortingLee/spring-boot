package com.example.springboot.controller;

import com.example.springboot.service.UserService;
import com.example.springboot.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String hello() {
        return "hello fucking spring";
    }

    @GetMapping("/user/{userSeq}")
    public User getUser(@PathVariable("userSeq") long userSeq) {
        return userService.getUser(userSeq);
    }

    @ResponseBody
    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
//        log.info("{}", user);
        userService.addUser(user);
    }

    @PutMapping("/user/{userSeq}")
    public void updateBoard(@PathVariable("userSeq") long userSeq) {
        userService.updateUser(userSeq);
    }

    @DeleteMapping("/user/{userSeq}")
    public void deleteBoard(@PathVariable("userSeq") long userSeq) {
        userService.deleteUser(userSeq);
    }

}


