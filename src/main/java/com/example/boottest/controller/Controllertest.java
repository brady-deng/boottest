package com.example.boottest.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.boottest.assembly.ObConfig;
import com.example.boottest.dao.UserDao;
import com.example.boottest.dto.Personob;
import com.example.boottest.dto.person;
import com.example.boottest.model.UserModel;
import com.example.boottest.service.servicetest;
import com.example.boottest.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
@RequestMapping("/test")
@Valid
@Api(tags = "this is a test")
public class Controllertest {


    @Autowired
    private servicetest serviceob;

    @Autowired
    private JedisPool jedisPool;


    @Resource
    private Personob personob;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ObConfig obConfig;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;





    private static Map<String, String> map = new HashMap<>();

    @GetMapping("/hello")
    @ApiOperation(value = "this is a hello test")
    @ApiImplicitParams(
            {@ApiImplicitParam(value = "name_api", name = "姓名lalala", paramType = "query", required = true)}
    )
    public Integer hello(@ApiIgnore String name) {
//        return String.format("Hello %s!", name)+ob.toString();
//        return ob.toString();
//        return serviceob.stringtest();
//        return serviceob.maptest();
//        ob.setAge("20");
//        ob.setName("deng");

        int save = serviceob.updateuser(name);


        return save;
    }


    @GetMapping("/redisSet")
    public void redisTest(String var) {

        jedisPool.getResource().set("ob",var);
        jedisPool.close();
    }

    @GetMapping("/redisGet")
    public String redisGet() {
        return (String) redisTemplate.opsForValue().get("ob");
    }

    @GetMapping("/test")
    @ApiOperation(value = "this is a notblank test")
    public String test(@Valid @NotBlank String Name, @Valid person ob) {
        return String.format("Hello %s!", Name);
    }

    @PostMapping("/person")
    @ApiOperation(value = "this is a person test")
    @ApiImplicitParams(
            {@ApiImplicitParam(name = "ob",value = "人员",paramType = "body")}
    )
    public String ptest(@ApiIgnore @RequestBody person ob){
//        log.info("this is a person test");
//        person ob = new person("deng","12");
        return ob.toString();
    }

    @GetMapping("/personTest")
    public String personTest(String[] name){
        log.info("personTest");
        String res = "hello";
        for (String item:name){
            res+=item;
            res+="\r\n";
        }
        System.out.println("return "+res);
        return res;
    }

    @GetMapping("/datetest")
    public String datetest(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) throws JsonProcessingException {
//        log.info("查询参数:{}",new ObjectMapper().writeValueAsString(date));
        return date.toString();
    }

    @PostMapping("/posttest")
    public String posttest(@Valid @ModelAttribute person ob, MultipartFile file){
//        return ob.toString();
//        return file.getName();
//        return ob.toString();
        return serviceob.mergetest(file,ob);
    }



    @GetMapping("/configurationtest")
    public String configurationtest(){
        return personob.toString();
    }

    @GetMapping("/swaggertest")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value= "项目开始时间, yyyy-MM-dd", required = true, paramType = "query")
    })
    public String datetest(@ApiIgnore @RequestParam(name = "startDate") String startDate, HttpServletResponse response){
        return startDate;
    }



    @GetMapping("/arraytest")
    public String[] arraytest(String[] names){
        return names;
    }

//    @GetMapping("/redistest")
//    public Boolean redistest(){
//        redisUtils.set("name","deng");
//        return redisUtils.exists("name");
//    }

    @GetMapping("/Systemtest")
    public void systemtest(){
        System.out.println("this is a test");
    }


    @GetMapping("/exceptiontest")
    public void exceptiontest(){
        String ob = null;
//        try{
//            ob.equals("222");
//        }
//        catch (Exception e){
//            System.out.println("e.getMessage()");
//        }
        ob.equals("234");
    }

    @GetMapping("/{id}")
    public PageSerializable<UserModel> user(@PathVariable("id") String id) {
        PageHelper.startPage(0,10);
        List<UserModel> usermodels = userDao.selectList(new LambdaQueryWrapper<>());
        List<UserModel> usermodels2 = userDao.selectList(new LambdaQueryWrapper<>());
        return new PageSerializable<>(usermodels);
    }

    @GetMapping("/users")
    public List<UserModel> users() {
        return userService.getList();
    }

    @PutMapping("/user/{name}")
    public String putUser(@PathVariable("name") String name) {
        UserModel usermodel = UserModel.builder().name(name).age(12).id(2).sex("Female").build();
        userService.save(usermodel);
        return "SUCCESS";
    }

    @PutMapping("/redis/{name}")
    public String redisPut(@PathVariable("name") String name) {
        String value = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(name, value);
        redisTemplate.expire(name, 30, TimeUnit.MINUTES);
        return value;
    }


    @GetMapping("/redis/{name}")
    public String redisGet(@PathVariable("name") String name) {
        return redisTemplate.opsForValue().get(name);
    }


    @PutMapping("/map/{name}")
    public String mapPut(@PathVariable("name") String name) {
        String value = UUID.randomUUID().toString();
        map.put(name, value);
        return value;
    }

    @GetMapping("/map/{name}")
    public String mapGet(@PathVariable("name") String name) {
        String value = UUID.randomUUID().toString();
        return map.get(name);
    }

    @GetMapping("/success")
    public String success() {
        log.info("Thread name:{}", Thread.currentThread().getName());
        return "success";
    }


    @GetMapping("/beanTest")
    public String ob() {
        return obConfig.getName();
    }


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
    }





}
