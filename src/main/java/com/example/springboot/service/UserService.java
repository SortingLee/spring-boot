package com.example.springboot.service;

import com.example.springboot.domain.User;
import com.example.springboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {

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
    public void updateUser(long userSeq) {
        userMapper.updateUser(userSeq);
    }

    //삭제함
    public void deleteUser(long userSeq) {
        userMapper.deleteUser(userSeq);
    }
}
