package com.warship.test.leedcode.shuzu;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class _1562_FindLatestStep {

    Map<Integer, Integer> contaienr = new HashMap<>();

    public int findLatestStep(int[] arr, int m) {
        if (m == 1 && arr.length == 1) {
            return 1;
        }
        if (arr.length == m) {
            return m;
        }
        contaienr.put(1, arr.length);
        for (int i = arr.length - 1; i >= 0; i--) {
            Iterator<Map.Entry<Integer, Integer>> iterator = contaienr.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() - entry.getKey() < m) {
                    iterator.remove();
                    continue;
                }
                if (entry.getKey() <= arr[i] && entry.getValue() >= arr[i]) {
                    if (arr[i] - entry.getKey() == m || entry.getValue() - arr[i] == m) {
                        return i;
                    }
                    if (arr[i] < entry.getValue()) {
                        contaienr.put(arr[i] + 1, entry.getValue());
                    }
                    if (arr[i] > entry.getKey()) {
                        contaienr.put(entry.getKey(), arr[i] - 1);
                    } else {
                        contaienr.remove(entry.getKey());
                    }

                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        Map<Integer, Integer> contaienr = new HashMap<>();
//        contaienr.put(1, 2);
//        contaienr.put(11, 22);
//        contaienr.put(111, 2222);
//        Iterator<Map.Entry<Integer, Integer>> iterator = contaienr.entrySet().iterator();
//        while (iterator.hasNext()) {
//            if (iterator.next().getKey() == 1) {
//                iterator.remove();
//            }
//        }
//        System.out.println(JSONObject.toJSONString(contaienr));
//
//        for (Map.Entry<Integer, Integer> entry : contaienr.entrySet()) {
//            if (entry.getKey() == 1) {
//                contaienr.put(1, 1111111);
//                contaienr.put(1222, 11111111);
//                contaienr.remove(1);
//                break;
//            }
//        }
//        System.out.println(JSONObject.toJSONString(contaienr));
//1
        _1562_FindLatestStep test = new _1562_FindLatestStep();
        int latestStep = test.findLatestStep(new int[]{10, 6, 9, 4, 7, 8, 5, 2, 1, 3}, 1);
        System.out.println(latestStep);
    }
}
