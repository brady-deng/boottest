package com.example.boottest.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

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
}
