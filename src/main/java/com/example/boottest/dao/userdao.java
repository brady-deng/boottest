package com.example.boottest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.boottest.dto.User;
import com.example.boottest.model.usermodel;

import java.util.ArrayList;

public interface userdao extends BaseMapper<usermodel> {

    public Integer updateuser(usermodel usermodel);
    public ArrayList<usermodel> selectname();
    public Integer insertUser(User user);
}
