package com.example.springboot.Controller;

import com.example.springboot.Service.UserService;
import com.example.springboot.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserController {
/*

    @Autowired
    private UserService userService;
*/

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userSeq}")
    public User getUser(@PathVariable("userSeq") long userSeq){
        return userService.getUser(userSeq);
    }

    @ResponseBody
    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        log.info("{}", user);
        userService.addUser(user);
//        User user = new User();
//
//        user.setUserID("2013");
//        user.setUserName("Shindd");
//        user.setUserPW("fnfnffn94!");
//        user.setGirlfriend(false);

        //userService.addUser(user);
    }

    @PutMapping("/user/{userSeq}")
    public void updateBoard() {

    }

    @DeleteMapping("/user/{userSeq}")
    public void deleteBoard() {

    }


  /*
  * pricate Service ...;
  * @RequestMapping(user/{user_seq}, GET 방식)        //가장 처음의 request를 받아와서
  * method(){
  *     service를 사용하여 로직을 처리한 뒤 (객체는 알아서 스프링이 만들어줌! 제어의 역전(IoC))
  *
  *     response를 반환한다.
  * }
  *
  * */

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


