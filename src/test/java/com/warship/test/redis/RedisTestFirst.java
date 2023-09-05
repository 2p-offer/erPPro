package com.warship.test.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class RedisTestFirst {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public void testSet(){
        String testKey = "testKey";
//        String testKey = stringRedisTemplate.opsForValue().get("testKey");
        System.out.println("res::::"+testKey);
    }

    @Test
    public void test(){
        String key = "wang";
        String s = stringRedisTemplate.opsForValue().get(key);
        System.out.println("result:"+s);

    }
}
