package com.example.boottest.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.boottest.dto.User;
import com.example.boottest.model.UserModel;

import java.util.ArrayList;

public interface UserDao extends BaseMapper<UserModel> {

    public Integer updateuser(UserModel usermodel);
    public ArrayList<UserModel> selectname();
    public Integer insertUser(User user);
}
