package com.example.springboot.controller;

import com.example.springboot.service.UserService;
import com.example.springboot.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService userService;

//    web browser에서 localhost:8080/hello가 들어오면 내장 톰캣 서버(WAS)에 의해 Spring이 Mapping하고 있는 곳으로 던져 method 실행.
    @GetMapping("hello")
    public String hello(Model model) {              //MVC에서 M의 Model
        model.addAttribute("data", "hello thymeleaf!!");         //key, value

        return "hello";     //resources의 templates에 hello라는 html파일과 matching됨
    }
//    기본적으로 Controller에서 return값으로 문자를 반환하게 되면 viewResolver가 resources:templates/{return값}.html과 매핑되어 동작한다.
//    지금은 뭔가 약간 matching되지 않은 것 같은데.. thymeleaf 의존성 주입이 안된건가..? 아님 templates 디렉토리를 임의로 만들어서 그런건가???

    @GetMapping("/user/{userSeq}")
    public User getUser(@PathVariable("userSeq") long userSeq) {
        return userService.getUser(userSeq);
    }

    @ResponseBody
    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
//        log.info("{}", user);
//        println등과 같은 출려은 하지 않는다! 로그 관련 내용을 확인하지 못하기 때문
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


