package com.warship.leedcode.数据结构;


import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个简单版本的堆积结构
 */
public class _xx_Heap {

    private final List<Integer> container;

    public _xx_Heap(int size) {
        container = new ArrayList<>(size);
    }

    public _xx_Heap(List<Integer> container) {
        this.container = container;
        heapify();
    }

    public static void main(String[] args) {
        List<Integer> container = Lists.newArrayList(3, 1, 433, 2, 44, 21, 12, 5);
        _xx_Heap heap = new _xx_Heap(container);
        System.out.println("INIT:" + heap);

        int size = heap.size();
        for (int i = 0; i < size; i++) {
            System.out.println(heap.pop());
        }

    }

    /**
     * 堆化
     * 1.创建一个空container,将目标数组按个add()进container
     * 2.从最后一个非叶子节点开始，直到跟节点。对所有节点执行down操作
     */
    private void heapify() {
        // chatGPT提示: 当前的 heapify 方法从 (container.size() - 1) / 2 开始向下调整，这样可能会多执行一次循环。为了确保边界条件正确，可以从 container.size() / 2 - 1 开始。
//        for (int i = (container.size() - 1) / 2; i >= 0; i--) {
        for (int i = container.size() / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }


    public int pop() {
        if (container.isEmpty()) {
            throw new RuntimeException("堆列表为空,无法pop");
        }
        int res = container.get(0);
        int newInt = container.get(container.size() - 1);
        container.set(0, newInt);
        container.remove(container.size() - 1);
        down(0);
        return res;
    }

    public void add(int num) {
        container.add(num);
        up(container.size() - 1);
    }

    /**
     * 目标元素上浮
     *
     * @param targetIndex 目标元素索引
     */
    private void up(int targetIndex) {
        //1 递归方式
//        if (targetIndex == 0) {
//            return;
//        }
//        int parentIndex = parentIndex(targetIndex);
//        if (get(targetIndex) > get(parentIndex)) {
//            swap(targetIndex, parentIndex);
//            up(parentIndex);
//        }

        //2 迭代方式
        while (targetIndex > 0) {
            int parentIndex = parentIndex(targetIndex);
            if (container.get(targetIndex) > container.get(parentIndex)) {
                swap(targetIndex, parentIndex);
                targetIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * 目标元素下沉
     *
     * @param targetIndex 目标元素索引
     */
    private void down(int targetIndex) {
        //1 递归方式
//        if (targetIndex >= container.size() - 1) {
//            return;
//        }
//        int leftIndex = childLeftIndex(targetIndex);
//        int rightIndex = childRightIndex(targetIndex);
//        int leftNum = leftIndex >= container.size() ? Integer.MIN_VALUE : get(leftIndex);
//        int rightNum = rightIndex >= container.size() ? Integer.MIN_VALUE : get(rightIndex);
//        int maxNum = Math.max(leftNum, rightNum);
//        if (maxNum > get(targetIndex)) {
//            int swapIndex = maxNum == leftNum ? leftIndex : rightIndex;
//            swap(targetIndex, swapIndex);
//            down(swapIndex);
//        }
        //2 迭代方式
        int size = container.size();
        while (targetIndex < size / 2) {
            int leftIndex = childLeftIndex(targetIndex);
            int rightIndex = childRightIndex(targetIndex);
            int maxIndex = (rightIndex < size && container.get(rightIndex) > container.get(leftIndex)) ? rightIndex : leftIndex;
            if (container.get(targetIndex) >= container.get(maxIndex)) {
                break;
            }
            swap(targetIndex, maxIndex);
            targetIndex = maxIndex;
        }
    }

    private void swap(int aIndex, int bIndex) {
        int tmp = container.get(aIndex);
        container.set(aIndex, container.get(bIndex));
        container.set(bIndex, tmp);
    }


    /**
     * 获取左子节点索引
     *
     * @param targetIndex 目标索引
     * @return
     */
    private int childLeftIndex(int targetIndex) {
        return targetIndex * 2 + 1;
    }

    /**
     * 获取右子节点索引
     *
     * @param targetIndex 目标索引
     * @return
     */
    private int childRightIndex(int targetIndex) {
        return targetIndex * 2 + 2;
    }

    /**
     * 获取父节点索引
     *
     * @param targetIndex 目标索引
     * @return
     */
    private int parentIndex(int targetIndex) {
        int res = (targetIndex - 1) / 2;
        if (res < 0) {
            throw new RuntimeException("超过数据长度, < 0");
        }
        return res;
    }

    /**
     * 获取第N个元素
     *
     * @param index 目标索引
     * @return
     */
    private int get(int index) {
        if (index < 0 || index >= container.size()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return container.get(index);
    }

    public int size() {
        return container.size();
    }

    @Override
    public String toString() {
        return container.toString();
    }
}
