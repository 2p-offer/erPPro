package com.warship.test.javabase.filedeal;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileDeal {
    public static void main(String[] args) throws Exception {
//        String recept = "emi";
//        System.out.println(recept.charAt(10));
//        if("e".equals(String.valueOf(recept.charAt(10)))){
//            System.out.println(0);
//        }else{
//            System.out.println(1);
//        }
        String filePath = "E:\\secureCRTDownload\\New.out";
        getOrderId(filePath);
    }

    public static void getOrderId(String filePath) throws Exception{
        Set<String> set = new HashSet<String>();
        File file = new File(filePath);
        InputStreamReader read = new InputStreamReader(
                new FileInputStream(file), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;

        while ((lineTxt = bufferedReader.readLine()) != null)
        {
            String[] split = lineTxt.split("&transactionId=");
            String and = split[1];
            String substring = and.substring(0, and.length() - 1);
            set.add("'GPA"+substring+"'");
        }
        bufferedReader.close();
        read.close();
        System.out.println(set.size());
        System.out.println(set);
    }

    public static void getRoleId()  throws Exception {
        Set<String> set = new HashSet<String>();
        File file = new File("E:\\secureCRTDownload\\M.out");
        InputStreamReader read = new InputStreamReader(
                new FileInputStream(file), "UTF-8");
        BufferedReader bufferedReader = new BufferedReader(read);
        String lineTxt = null;

        while ((lineTxt = bufferedReader.readLine()) != null)
        {
            String[] split = lineTxt.split("&through_cargo=");

            String and = split[1];
            and = and.split("&clientChannel=")[0];
            set.add("'"+and+"'");
        }
        bufferedReader.close();
        read.close();
        System.out.println(set.size());
        System.out.println(set);
    }

}
