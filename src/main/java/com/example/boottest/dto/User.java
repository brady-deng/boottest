package com.example.boottest.dto;

import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@TableName("user")
public class User {
    private int id;
    private String name;
    private int age;

    private Integer isDelete;

    @TableField(value = "sex", fill = FieldFill.INSERT_UPDATE)
    private String sex;


    public static void main(String[] args) {
        User ob = User.builder().id(1).name("deng").age(23).build();
        Map<User, User> map = new HashMap<>();
        map.put(ob, ob);
        System.out.println(map);
        System.out.println(map.get(ob));
        ob.setId(2);
        System.out.println("------------");
        System.out.println(map);
        System.out.println(map.get(ob));
    }
}
