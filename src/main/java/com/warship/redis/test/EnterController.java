//package com.warship.test.redis.test;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@RequestMapping("/redis")
//@Controller
//public class EnterController {
//
//    private final String CONNECTOR = "=";
//
//    protected final Logger log = LogManager.getLogger(EnterController.class);
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @ResponseBody
//    @RequestMapping("/test")
//    public String firstTest(){
//        String testKey = "testKey";
//        testKey = stringRedisTemplate.opsForValue().get("testKey");
//        return testKey;
//    }
//
//    @ResponseBody
//    @GetMapping("/get/{key}")
//    public String getKeyVal(@PathVariable String key){
//        if(key == null || key.isEmpty()){
//            log.error("EnterController >> getKeyVal error ,key is illagel.key:"+key);
//            return null;
//        }
//        return stringRedisTemplate.opsForValue().get(key);
//    }
//
//    @ResponseBody
//    @GetMapping("/set/{keyVal}")
//    public String setKeyVal(@PathVariable String keyVal){
//        if(keyVal == null || keyVal.isEmpty()||!keyVal.contains(CONNECTOR)){
//            log.error("EnterController >> getKeyVal error ,key is illagel.data:"+keyVal);
//            return null;
//        }
//        String key = keyVal.split(CONNECTOR)[0];
//        String val = keyVal.split(CONNECTOR)[1];
//        String testKey = "testKey";
//        stringRedisTemplate.opsForValue().set(key,val);
//        return keyVal;
//    }
//
//}
//
