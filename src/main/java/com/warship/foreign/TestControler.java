//package com.warship.test.foreign;
//
//import com.alibaba.fastjson2.JSONArray;
//import com.alibaba.fastjson2.JSONObject;
//import com.alibaba.fastjson2.JSONObject;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Controller
//public class TestControler {
//
//    protected final Logger log = LogManager.getLogger(TestControler.class);
//
//    @Autowired
//    TestDao testDao;
//
//    int i = 1;
//
//    @RequestMapping("/test")
//    @ResponseBody
//    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        final ServletOutputStream outputStream = response.getOutputStream();
//        Thread t1 = new Thread(() -> {
//            String a = request.getParameter("a");
//            try {
////                PrintWriter writer = response.getWriter();
////                writer.write("write");
//                outputStream.print("aa");
//                System.out.println("-+++-----------++++-----" + a);
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        t1.start();
////        request.getParameter("a");
//        try {
//            outputStream.print("bb");
//            System.out.println("hello");
//
//            throw new RuntimeException("12312");
//
//        } catch (IOException ex) {
//            System.out.println("IOException");
//        }
//    }
//
//    //    @PathVariable String roleId
//    @GetMapping("/getRole")
//    @ResponseBody
//    public void getRole() {
//        TestRole role = testDao.getRole(100100000000L);
//        System.out.println("0------------------------");
//        System.out.println(role);
//    }
//
//
//    @GetMapping("/testDoubleClient")
//    @ResponseBody
//    public void testDoubleClient() throws InterruptedException {
//
//
//    }
//
//    @GetMapping("/testLog")
//    @ResponseBody
//    public void testLog() throws InterruptedException {
//        log.info("test Log info,I:" + i);
//        log.debug("test Log debug,I:" + i);
//        log.error("test Log error,I:" + i);
//
//    }
//
//    public void saveData() {
//        JSONArray jsonArray = new JSONArray();
//        for (int i = 0; i < 1000; i++) {
//            JSONObject obj = new JSONObject();
//            obj.put("id", 1);
//            obj.put("name", i);
//            obj.put("age", i);
//            jsonArray.add(obj);
//        }
//        testDao.saveData(jsonArray);
//    }
//
//    public void delData() {
//
//        testDao.delNameAge(1);
//    }
//
//    @ResponseBody
//    @RequestMapping("/tryBatch")
//    public void testBatchUpdate() throws Exception {
//        log.info("testBatchUpdate >> ");
//        Thread t1 = new Thread(() -> {
//            saveData();
//        });
//        Thread t2 = new Thread(() -> {
//            delData();
//        });
//        t1.start();
//        Thread.sleep(1000);
//        t2.start();
//    }
//
//    @ResponseBody
//    @RequestMapping("/trySave")
//    public void testBatchSave() {
//        log.info("trySave >> ");
//        Thread t1 = new Thread(() -> {
//            saveData();
//        });
//        t1.start();
//    }
//
//    @ResponseBody
//    @RequestMapping("/tryDel")
//    public void testDel() {
//        log.info("tryDel >> ");
//
//        Thread t2 = new Thread(() -> {
//            delData();
//        });
//        t2.start();
//    }
//
//
//    public static void main(String[] args) throws Exception {
//
//    }
//}
//package com.warship.test.foreign;
//
//import com.alibaba.fastjson2.JSONArray;
//import com.alibaba.fastjson2.JSONObject;
//import com.alibaba.fastjson2.JSONObject;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.ServletOutputStream;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Controller
//public class TestControler {
//
//    protected final Logger log = LogManager.getLogger(TestControler.class);
//
//    @Autowired
//    TestDao testDao;
//
//    int i = 1;
//
//    @RequestMapping("/test")
//    @ResponseBody
//    public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//        final ServletOutputStream outputStream = response.getOutputStream();
//        Thread t1 = new Thread(() -> {
//            String a = request.getParameter("a");
//            try {
////                PrintWriter writer = response.getWriter();
////                writer.write("write");
//                outputStream.print("aa");
//                System.out.println("-+++-----------++++-----" + a);
//
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        t1.start();
////        request.getParameter("a");
//        try {
//            outputStream.print("bb");
//            System.out.println("hello");
//
//            throw new RuntimeException("12312");
//
//        } catch (IOException ex) {
//            System.out.println("IOException");
//        }
//    }
//
//    //    @PathVariable String roleId
//    @GetMapping("/getRole")
//    @ResponseBody
//    public void getRole() {
//        TestRole role = testDao.getRole(100100000000L);
//        System.out.println("0------------------------");
//        System.out.println(role);
//    }
//
//
//    @GetMapping("/testDoubleClient")
//    @ResponseBody
//    public void testDoubleClient() throws InterruptedException {
//
//
//    }
//
//    @GetMapping("/testLog")
//    @ResponseBody
//    public void testLog() throws InterruptedException {
//        log.info("test Log info,I:" + i);
//        log.debug("test Log debug,I:" + i);
//        log.error("test Log error,I:" + i);
//
//    }
//
//    public void saveData() {
//        JSONArray jsonArray = new JSONArray();
//        for (int i = 0; i < 1000; i++) {
//            JSONObject obj = new JSONObject();
//            obj.put("id", 1);
//            obj.put("name", i);
//            obj.put("age", i);
//            jsonArray.add(obj);
//        }
//        testDao.saveData(jsonArray);
//    }
//
//    public void delData() {
//
//        testDao.delNameAge(1);
//    }
//
//    @ResponseBody
//    @RequestMapping("/tryBatch")
//    public void testBatchUpdate() throws Exception {
//        log.info("testBatchUpdate >> ");
//        Thread t1 = new Thread(() -> {
//            saveData();
//        });
//        Thread t2 = new Thread(() -> {
//            delData();
//        });
//        t1.start();
//        Thread.sleep(1000);
//        t2.start();
//    }
//
//    @ResponseBody
//    @RequestMapping("/trySave")
//    public void testBatchSave() {
//        log.info("trySave >> ");
//        Thread t1 = new Thread(() -> {
//            saveData();
//        });
//        t1.start();
//    }
//
//    @ResponseBody
//    @RequestMapping("/tryDel")
//    public void testDel() {
//        log.info("tryDel >> ");
//
//        Thread t2 = new Thread(() -> {
//            delData();
//        });
//        t2.start();
//    }
//
//
//    public static void main(String[] args) throws Exception {
//
//    }
//}
