package  com.warship.leedcode.数据结构;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * 手撕 LRU
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *  
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 *
 *
 * 执行用时：
 * 19 ms
 * , 在所有 Java 提交中击败了 95.11%的用户
 * 内存消耗：
 * 46 MB
 * , 在所有 Java 提交中击败了 98 % 的用户
 *
 * 为什么我写的比官方的快这么多？
 *
 */
public class _146_LRU {
    //当前缓存类元素数量
    private int size;
    //缓存类元素阈值，超过这个值，再添加要删除最后一个使用过的元素
    private int capacity;
    //头结点[伪头结点。不是真正的数据头结点，真正的数据头结点是 head.next]
    private LRUNode head;
    //尾节点[伪尾节点，不是真正的数据尾节点，真正的数据尾节点是 tail.prev]
    private LRUNode tail;
    //用于存储key - value 的map。用于O(1)获取元素
    private Map<Integer, LRUNode> container;

    public _146_LRU(int capacity) {
        if (capacity < 1) {
            capacity = 1;
        }
        this.capacity = capacity;
        head = new LRUNode();
        tail = new LRUNode();
        head.next = tail;
        tail.prev = head;
        container = new HashMap<>();
    }

    public int get(int key) {
        LRUNode lruNode = container.get(key);
        if (lruNode == null) {
            return -1;
        }
        removeNode(lruNode);
        addToHead(lruNode);
        return lruNode.value;
    }


    /**
     * 当一个节点被初次插入是，直接放到头结点
     * 当一个节点被更新时，实现方式是先删除这个节点，再把这个节点插入到头部
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        LRUNode lruNode = container.get(key);
        if (lruNode != null) {
            removeNode(lruNode);
        }
        lruNode = new LRUNode(key, value);
        container.put(key, lruNode);
        addToHead(lruNode);
        if (size > capacity) {
            removeTail();
        }
    }

    /**
     * 将node 节点添加至头结点
     * 当一个新节点插入之后使用
     *
     * @param node
     */
    private void addToHead(LRUNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    /**
     * 删除node 节点
     *
     * @param node
     */
    private void removeNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    /**
     * 删除最后一个节点
     * 当缓存数据量>阈值时调用，删除最后使用的一个节点
     */
    private void removeTail() {

        container.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size--;
    }


    class LRUNode {
        public int key;
        public int value;
        public LRUNode prev;
        public LRUNode next;

        LRUNode() {
        }

        LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
