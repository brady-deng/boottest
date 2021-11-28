package com.example.boottest.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boottest.dao.UserDao;
import com.example.boottest.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/10/31
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserModel> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public List<UserModel> getList() {
        List<UserModel> usermodels = userDao.selectList(new LambdaQueryWrapper<>());
        List<UserModel> usermodels2 = userDao.selectList(new LambdaQueryWrapper<>());
        return usermodels;
    }
}
