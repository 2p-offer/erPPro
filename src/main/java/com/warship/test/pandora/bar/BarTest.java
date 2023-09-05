package com.warship.test.pandora.bar;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author erp
 */
public class BarTest {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> source = new TreeMap<>();
        source.put(1, 1000);
        source.put(2, 10000);
        source.put(3, 1000);

        TreeMap<Integer, Integer> source2 = new TreeMap<>();
        source2.put(1, 100);
        source2.put(2, 100);
        source2.put(3, 500);

        rideQualityWeight(source, source2);
        System.out.println("ans:" + source);
    }

    public static void rideQualityWeight(Map<Integer, Integer> originWeight,
                                         Map<Integer, Integer> rideWeight) {
        for (Map.Entry<Integer, Integer> rideEntry : rideWeight.entrySet()) {
            int rideKey = rideEntry.getKey();
            int rideVal = rideEntry.getValue();
            if (rideVal == 0) {
                continue;
            }
            int oldValue = originWeight.getOrDefault(rideKey, 0);
            //当前加成品质应该加成的值
            int addValue = oldValue * rideVal / 100000;
            if (addValue == 0) {
                continue;
            }
            addToWeightMap(originWeight, rideKey, addValue);
        }
    }

    private static void addToWeightMap(Map<Integer, Integer> originWeight, int key, int addValue) {
        //真正添加多少
        int trueAdd = 0;
        for (Map.Entry<Integer, Integer> originEntry : originWeight.entrySet()) {
            //遍历到当前key，说明配置的添加概率，比之前品质的概率和要高。
            if (originEntry.getKey() == key) {
                originEntry.setValue(originEntry.getValue() + trueAdd);
                break;
            }
            //已经添加完毕，直接修改目标概率
            if (trueAdd == addValue) {
                originWeight.merge(key, trueAdd, Integer::sum);
                break;
            }
            int originVal = originEntry.getValue();
            //还需要添加多少
            int needAdd = addValue - trueAdd;
            if (originVal <= needAdd) {
                //当前的全加上
                //原始数据清零
                trueAdd += originVal;
                originEntry.setValue(0);
            } else {
                //加上需要添加的部分
                //源权重集合扣除添加的部分
                trueAdd += needAdd;
                originEntry.setValue(originVal - needAdd);
            }
//            log.debug("BarServiceImpl >> addToWeightMap ,needAdd:{}", needAdd);
        }
//        log.debug("BarServiceImpl >> addToWeightMap ,key:{},addValue:{}", key, addValue);
        System.out.println(originWeight);
    }
}
