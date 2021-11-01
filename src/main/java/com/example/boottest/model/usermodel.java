package com.example.boottest.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class usermodel {
    private int id;
    private String name;
    private int age;
    private String sex;
}
