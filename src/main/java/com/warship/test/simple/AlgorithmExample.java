package com.warship.test.simple;

public class AlgorithmExample {

    public static int customAlgorithm(int input) {
        // 将参数转为字符串s
        String s = Integer.toString(input);

        // 在字符串前面补全'0'，保证长度为6个字节
        while (s.length() < 6) {
            s = "0" + s;
        }

        // 将第一个字节以外的字节反转得到新字符串sNew
        String substring = s.substring(0, 1);
        System.out.println("sub:" + substring);
        StringBuilder sNewBuilder = new StringBuilder(
                substring);
        sNewBuilder.append(new StringBuilder(s.substring(1)).reverse().toString());
        String sNew = sNewBuilder.toString();

        // 将sNew转成int，然后对300000取异或
        int sNewInt = Integer.parseInt(sNew);
        int result = sNewInt ^ 300000;

        return result;
    }

    public static void main(String[] args) {
        int input = 12222;
        int result = customAlgorithm(input);
        System.out.println("Input: " + input);
        System.out.println("Output: " + result);

        //        Map<String, String> container = new HashMap<>();
        //        for (int i = 10001; i < 19999; i++) {
        //            int result = customAlgorithm(i);
        //            String resStr = String.valueOf(result);
        //            if (container.containsKey(resStr)) {
        //                System.out.println("存在,res:" + result + ",old:" + container.get(resStr) + ",new:" + i);
        //            }
        //            container.put(resStr, String.valueOf(i));
        //            System.out.println("key:" + i + ",value:" + result);
        //        }
        ////        System.out.println(container);
    }
}
