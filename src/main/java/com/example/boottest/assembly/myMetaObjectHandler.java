package com.example.boottest.assembly;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.boottest.dto.User;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class myMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
//        this.strictInsertFill(metaObject,"sex",String.class,"Female_i");
        this.setFieldValByName("sex","Female_i", metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
//        this.strictUpdateFill(metaObject,"sex",String.class,"Female_u");
        this.setFieldValByName("sex","Female_u",metaObject);
    }
}
