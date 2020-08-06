package com.example.springboot.Mappter;

import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
@Component
public interface UserMapper {
    //CRUD

    //GET
    User selectUser(@Param("userSeq") long userSeq);

    //POST
    void insertUser(User user);

    //PUT
    void updateUser(@PathVariable("userSeq") long userSeq);

    //DELETE
    void deleteUser(@PathVariable("userSeq") long userSeq);


}