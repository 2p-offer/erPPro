//package com.warship.test.redis.ranking;
//
//import com.alibaba.fastjson2.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@RequestMapping("/ranking")
//@Controller
//public class RankingControler {
//
//    @Autowired
//    StringRedisTemplate stringRedisTemplate;
//
//    @RequestMapping("/add")
//    public String addRanker(JSONObject addRanker){
//        Ranker ranker = addRanker.toJavaObject(Ranker.class);
//        stringRedisTemplate.opsForZSet().add(ranker.name, String.valueOf(ranker.age),ranker.score);
//
//        return "";
//    }
//
//
//    @RequestMapping("/del/{name}")
//    public String delRanker(@PathVariable String name){
////        stringRedisTemplate.opsForZSet().remove()
//        return "";
//    }
//
//    @RequestMapping("/get/{num}")
//    public String getRanking(@PathVariable int num){
//        return "";
//    }
//
//
//    class Ranker{
//        public String name;
//
//        public int age;
//
//        public double score;
//    }
//
//
//}
