package com.example.boottest.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boottest.dao.userdao;
import com.example.boottest.model.usermodel;
import org.springframework.stereotype.Service;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/10/31
 **/
@Service
public class UserServiceImpl extends ServiceImpl<userdao, usermodel> implements UserService {
}
