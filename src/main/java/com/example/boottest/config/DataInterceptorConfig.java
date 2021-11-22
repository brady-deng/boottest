package com.example.boottest.config;


import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

/**
 * DAO拦截配置
 * Created on 2018/12/20 17:38
 *
 * @author <a href="mailto: lw83942@sina.com">刘韦</a>
 * @version 1.0
 */
@Configuration
public class DataInterceptorConfig {

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    DataInterceptorConfig() {

    }

    @Bean
    @ConfigurationProperties(
            prefix = "pagehelper"
    )
    public Properties pageHelperProperties() {
        return new Properties();
    }

    @PostConstruct
    public void addPageInterceptor() {

        //分页拦截器
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.putAll(this.pageHelperProperties());


        for (Object sqlSessionObject : this.sqlSessionFactoryList) {
            SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) sqlSessionObject;
            sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
        }

    }

}
