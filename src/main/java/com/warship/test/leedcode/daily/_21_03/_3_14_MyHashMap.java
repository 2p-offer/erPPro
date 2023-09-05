package com.warship.test.leedcode.daily._21_03;

import java.util.Iterator;
import java.util.LinkedList;

public class _3_14_MyHashMap {


    public static void main(String[] args) {
        _3_14_MyHashMap myMap = new _3_14_MyHashMap();

        myMap.put(2,1);
        myMap.put(2,2);
        int i = myMap.get(2);
        System.out.println(i);
    }


    //为什么 769 ？  质数。 见下面注释
    private static final int BASE = 769;
    private LinkedList[] data;

    private class Entry{
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public _3_14_MyHashMap() {
        data = new LinkedList[BASE];
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = hash(key);
        LinkedList<Entry> list = data[hash];
        if(list == null){
            list = new LinkedList<>();
            data[hash] = list;
        }
        for(Entry tmp : list){
            if(tmp.getKey() == key){
                tmp.setValue(value);
                return;
            }
        }
        list.addLast(new Entry(key,value));
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int res = -1;
        int hash = hash(key);

        LinkedList<Entry> list = data[hash];
        if(list == null){
            return  res;
        }
        for(Entry tmp : list){
            if(tmp.getKey() == key){
                return tmp.getValue();
            }
        }
        return res;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = hash(key);
        LinkedList<Entry> list = data[hash];
        if(list == null){
            return;
        }
        Iterator<Entry> iterator = list.iterator();
        while (iterator.hasNext()){
            if(iterator.next().getKey() == key){
                iterator.remove();
            }
        }
    }

    /**
     * hash散列，确定桶的位置
     * @param key
     * @return
     */
    private int hash(int key) {
        return key % BASE;
    }


}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 * <p>
 * <p>
 * 查了下质数取模，其实是利用了同余的概念：当元素是个有规律的等差数列时，并且和基数（数组大小）最大公约数不为1时，就会造成哈希映射时冲突变高（数组某些位置永远不会有值）。比如数列0,6,12,18,24,30...，
 * <p>
 * base为10，取模(0,6,2,8,4,0...)后，放入哈希表中位置将只能在0,2,4,6,8这几个数组位置上；
 * 但我们如果把base取7（数组大小甚至比10小），同样数列取模后(0,6,5,4,3,2,1,0,...)，可以分布在哈希表中的0,1,2,3,4,5,6所有位置上；
 * 所以可以使得哈希表中每个位置都“有用武之地”。
 */


/**
 *
 * 查了下质数取模，其实是利用了同余的概念：当元素是个有规律的等差数列时，并且和基数（数组大小）最大公约数不为1时，就会造成哈希映射时冲突变高（数组某些位置永远不会有值）。比如数列0,6,12,18,24,30...，
 *
 * base为10，取模(0,6,2,8,4,0...)后，放入哈希表中位置将只能在0,2,4,6,8这几个数组位置上；
 * 但我们如果把base取7（数组大小甚至比10小），同样数列取模后(0,6,5,4,3,2,1,0,...)，可以分布在哈希表中的0,1,2,3,4,5,6所有位置上；
 * 所以可以使得哈希表中每个位置都“有用武之地”。
 */