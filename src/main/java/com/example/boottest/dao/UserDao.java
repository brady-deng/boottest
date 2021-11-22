package com.example.boottest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.boottest.dto.User;
import com.example.boottest.model.Usermodel;

import java.util.ArrayList;

public interface UserDao extends BaseMapper<Usermodel> {

    public Integer updateuser(Usermodel usermodel);
    public ArrayList<Usermodel> selectname();
    public Integer insertUser(User user);
}
