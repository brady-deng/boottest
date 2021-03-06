package com.example.boottest.service;


import com.example.boottest.dao.UserDao;
import com.example.boottest.model.UserModel;
import com.example.boottest.dto.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;

@Service
public class servicetest implements servicete{
    @Resource
    private UserDao userDaoOb;
    @Autowired
    private ApplicationContext applicationContext;

    @Transactional
    public Integer updateuser(String name){
        UserModel udermodelOb = new UserModel();

//        udermodelOb.setSex("F");
        int save = userDaoOb.updateuser(udermodelOb);
        this.testPublic();
        this.testPrivate();
        servicetest ob = (servicetest) applicationContext.getBean("servicetest");
        ob.testPublic();
        ob.testPrivate();

        return save;
    }


    public void testPublic() {
        System.out.println("hello");
    }


    private void testPrivate() {
        System.out.println("this is private");
    }
    public String mergetest(MultipartFile file, person ob){
        return ob.toString();
    }

    public ArrayList<UserModel> getnames(){
        return userDaoOb.selectname();
    }

    public void decimaltest(){
//        BigDecimal ob = BigDecimal.valueOf(2.344);
//        BigDecimal res = ob.setScale(2,BigDecimal.ROUND_HALF_UP);
//        System.out.println(ob);
        BigDecimal ob = BigDecimal.valueOf(2.333);
        System.out.println(ob.scale());
    }
}
