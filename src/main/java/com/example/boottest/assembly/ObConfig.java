package com.example.boottest.assembly;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2022/2/22
 **/
@Data
public class ObConfig implements InitializingBean {

    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.name = "deng";
    }
}
