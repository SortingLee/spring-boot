package com.example.springboot.Service;

import com.example.springboot.domain.User;
import com.example.springboot.Mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Service
public class UserService{

    /*DB에 저장된 userSeq위치의 Data로*/

    @Autowired
    private UserMapper userMapper;

    public User getUser(long userSeq) {
        return userMapper.selectUser(userSeq);
    }

    //추가함
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    //수정함
    public void updateUser(@PathVariable("userSeq") long userSeq) {
        userMapper.updateUser(userSeq);
    }

    //삭제함
    public void deleteUser(@PathVariable("userSeq") long userSeq) {
        userMapper.deleteUser(userSeq);
    }
}
