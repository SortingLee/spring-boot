package com.example.springboot.mapper;

import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    //CRUD

    //GET
    User selectUser(@Param("userSeq") long userSeq);

    //POST
    void insertUser(User user);

    //PUT
    void updateUser(@Param("userSeq") long userSeq);

    //DELETE
    void deleteUser(@Param("userSeq") long userSeq);


}