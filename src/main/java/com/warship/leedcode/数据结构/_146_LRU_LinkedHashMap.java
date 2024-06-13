package  com.warship.leedcode.数据结构;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * linkedhashmap 数据结构，天然支持。
 *
 * 执行用时：
 * 18 ms
 * , 在所有 Java 提交中击败了94.66% 的用户
 * 内存消耗：
 * 46.6 MB
 * , 在所有 Java 提交中击败了46.82%的用户
 */
public class _146_LRU_LinkedHashMap {
    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public _146_LRU_LinkedHashMap(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
