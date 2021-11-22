package com.example.boottest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@ComponentScan({"com.example.boottest.service"
		,"com.example.boottest.controller"
		,"com.example.boottest.assembly"
		,"com.example.boottest.dto"
		,"com.example.boottest.utils"
		,"com.example.boottest.task"
		,"com.example.boottest.controllertest"
		,"com.example.boottest.aspect"
		,"com.example.boottest.config"
}
)
@MapperScan(basePackages = {"com.example.boottest.dao","com.example.boottest.mapper"})
@EnableScheduling
@SpringBootApplication
public class BoottestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoottestApplication.class, args);
	}


}
