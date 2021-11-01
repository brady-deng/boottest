package com.example.boottest.utils;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class RedisUtils {


    @Resource
    private static RedisTemplate<String,Object> redisTemplate;

    public static boolean exists(String key) {return redisTemplate.hasKey(key);}

    public static void set(String key, Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    public static Object get(String key){return redisTemplate.opsForValue().get(key);}

    public static void addObject(String key, Object object) { redisTemplate.opsForValue().set(key,object);}

    public static void addObject(String key, Object object, int seconds){
        redisTemplate.opsForValue().set(key,object);
        redisTemplate.expire(key,seconds, TimeUnit.SECONDS);
    }

    public static void setAndExpire(String key, String value, int seconds){
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    public static void setAndExpireDay(String key, String value, int day){
        redisTemplate.opsForValue().set(key,value);
        redisTemplate.expire(key,day,TimeUnit.DAYS);
    }

    public static void setHashMapAndExpireDay(String key, Map<String, Object> hashmap, int day){
        setHashMap(key,hashmap);
        redisTemplate.expire(key,day,TimeUnit.DAYS);
    }
    public static boolean containsKey(String key) {return redisTemplate.hasKey(key);}
    public static Object getObject(String key) {return redisTemplate.opsForValue().get(key);}
    public static void setHash(String key, String field, String value){redisTemplate.opsForHash().put(key,field,value);}
    public static void setHash(String key, String field, Object value){redisTemplate.opsForHash().put(key,field,value);}

    public static String getHash(String key,String field){return (String) redisTemplate.opsForHash().get(key,field);}

    public static void delHashMap(String key, String field){redisTemplate.boundHashOps(key).delete(field);}

    public static void setHashMap(String key, Map<String,Object> hashmap){redisTemplate.opsForHash().putAll(key,hashmap);}

    public static Map<Object,Object> getHashmap(String key){return redisTemplate.opsForHash().entries(key);}

    public static void setSet(String key, Object object){redisTemplate.opsForSet().add(key,object);}

    public static Set<Object> getSet(String key){return redisTemplate.opsForSet().members(key);}

    public static Boolean isSetMember(String key, Object value) {return redisTemplate.opsForSet().isMember(key,value);}

    public static void setExpire(String key, Date endTime){
        long seconds = endTime.getTime() - System.currentTimeMillis();
        redisTemplate.expire(key, (int) (seconds/1000),TimeUnit.SECONDS);
    }

    public static Long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    public static void tailPush(String key, Object object){redisTemplate.opsForList().rightPush(key,object);}

    public static void headPush(String key, Object object){redisTemplate.opsForList().leftPush(key,object);}

    public static Object tailPop(String key){return redisTemplate.opsForList().rightPop(key);}

    public static Object headPop(String key){return redisTemplate.opsForList().leftPop(key);}

    public static void del(String key){
        if (exists(key)){
            redisTemplate.delete(key);
        }
    }

    public static void flushDB(){redisTemplate.getConnectionFactory().getConnection().flushDb();}

    public static Long increment(String key, long value){return redisTemplate.opsForValue().increment(key,value);}

    public static boolean setIfAbsent(String key, Object value){return redisTemplate.opsForValue().setIfAbsent(key,value);}
}

