package com.warship.test.leedcode.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
 * <p>
 * 示例 1:
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 示例 2:
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 示例 3:
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * <p>
 * 示例 4:
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 * <p>
 * 提示：
 * 死亡列表 deadends 的长度范围为 [1, 500]。
 * 目标数字 target 不会在 deadends 之中。
 * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 */
public class _752_OpenLock {
    public int openLock(String[] deadends, String target) {
        int res = 0;
        Queue<String> container = new LinkedList<String>();//核心1 ： 当前可以作为起点的节点
        Set<String> visited = new HashSet<String>();//核心2: 防止重复计算导致死循环，记录已经访问过的节点
        Set<String> deads = new HashSet<String>();//用于剪枝的限制条件
        container.add("0000");
        for (String tmp : deadends) {
            deads.add(tmp);
        }
        while (!container.isEmpty()) {
            int size = container.size();
            for(int j = 0 ;  j < size ;j++) {

                String cur = container.poll();
                if (target.equals(cur)) {
                    return res;
                }
                if (deads.contains(cur)) {
                    continue;
                }
                for (int i = 0; i < 4; i++) {
                    String up = up(cur, i);
                    if (!visited.contains(up)) {
                        container.offer(up);
                        visited.add(up);
                    }
                    String down = down(cur, i);
                    if (!visited.contains(down)) {
                        container.offer(down);
                        visited.add(down);
                    }
                }
            }

            res++;
        }
        return -1;
    }

    public String up(String target, int index) {
        char[] array = target.toCharArray();
        if (array[index] == '9') {
            array[index] = '0';
        } else {
            array[index]++;
        }
        return new String(array);
    }

    public String down(String target, int index) {
        char[] array = target.toCharArray();
        if (array[index] == '0') {
            array[index] = '9';
        } else {
            array[index]--;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        _752_OpenLock test = new _752_OpenLock();
        int i = test.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(i);
    }
}
