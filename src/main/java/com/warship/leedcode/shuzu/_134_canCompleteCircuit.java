package com.warship.leedcode.shuzu;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 * <p>
 * 示例 1:
 * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * <p>
 * 示例 2:
 * 输入: gas = [2,3,4], cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 * <p>
 * 提示:
 * gas.length == n
 * cost.length == n
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 */
public class _134_canCompleteCircuit {

    public int canCompleteCircuit_(int[] gas, int[] cost) {

        int i = 0;
        while (i < gas.length) {
            int loopNum = 0;
            int has = 0;
            int currentStep = i;
            while (loopNum < gas.length) {
                currentStep = currentStep % gas.length;
                has += gas[currentStep];
                if (has >= cost[currentStep]) {
                    has -= cost[currentStep];
                    loopNum++;
                    currentStep++;
                } else {
                    break;
                }
            }
            if (currentStep < i) {
                return -1;
            }
            i = currentStep + 1;
            if (loopNum == gas.length) {
                return currentStep % gas.length;
            }
        }
        return -1;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int length = 2 * gas.length;
        int have = 0;
        int startIndex = 0;
        for (int i = 0; i < length; i++) {
            int index = i % gas.length;
            have += gas[index];
            if (have < cost[index]) {
                have = 0;
            } else {
                have -= cost[index];
            }
        }
        return -1;
    }

    /**
     * 我解决这道题的核心思想：
     * 如果车从a点经过b、c、d点但是无法到达下一个e点。那么从b、c、d中的任何一点开始都无法到达e点。
     * 因为从a出发到达b、c、d时的当前油量一定大于在b、c、d开始的油量。
     * 所以这道题最多遍历两趟数组就可以完成。
     */

}
