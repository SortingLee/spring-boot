package com.example.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/")
    public String helloSpring(){
        return "Hello Spring!\n";
    }
/*
    @RequestMapping("/")
    public User helloUser(){
        User user = new User();

        user.setUserID("leejungyeol");
        user.setUserPW("lee123jung456yeol&*(");
        user.setUserName("이정열");

        return user;
    }
    */
}
