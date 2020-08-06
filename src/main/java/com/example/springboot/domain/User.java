package com.example.springboot.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("User")
public class User {
    private Long userSeq;
    private String name;
    private String gender;
    private Integer age;
}
