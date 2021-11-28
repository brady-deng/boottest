package com.example.boottest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.boottest.model.UserModel;

import java.util.List;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2021/10/31
 **/
public interface UserService extends IService<UserModel> {

    List<UserModel> getList();
}
