package  com.warship.leedcode.daily._21_04;

import java.util.Arrays;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 示例 1：
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * <p>
 * 示例 2：
 * 输入：weights = [3,2,2,4,1,4], D = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * <p>
 * 示例 3：
 * 输入：weights = [1,2,3,1,1], D = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * 提示：
 * * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 */
public class _4_26_ShipWithinDays {

    /**
     * 最一开始想到的接近暴力解
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int currentWeight = getMax(weights);
        while (!checkWeight(weights, D, currentWeight)) {
            currentWeight++;
        }
        return currentWeight;
    }


    private int getMax(int[] weights) {
        int res = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] > res) {
                res = weights[i];
            }
        }
        return res;
    }

    private boolean checkWeight(int[] weights, int d, int currentWeight) {
        int sum = weights[0];
        int num = 1;
        for (int i = 1; i < weights.length; i++) {
            sum += weights[i];
            if (sum > currentWeight) {
                sum = weights[i];
                num++;
            }
            if (num > d) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用二分直接快了几十倍
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays_BinarySearch(int[] weights, int D) {
        int minWeigth = Arrays.stream(weights).max().getAsInt();
        int maxWeigth = Arrays.stream(weights).sum();
        int middle = (minWeigth + maxWeigth) / 2;
        while (minWeigth < maxWeigth) {
            if (checkWeight(weights, D, middle)) {
                maxWeigth = middle;
            } else {
                minWeigth = ((minWeigth + maxWeigth) / 2) + 1;
            }
            middle = (minWeigth + maxWeigth) / 2;
        }

        return minWeigth;
    }


    /**
     * 不比我自己的二分快啊
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays_main(int[] weights, int D) {
        // 确定二分查找左右边界
        int left = Arrays.stream(weights).max().getAsInt(), right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            // need 为需要运送的天数
            // cur 为当前这一天已经运送的包裹重量之和
            int need = 1, cur = 0;
            for (int weight : weights) {
                if (cur + weight > mid) {
                    ++need;
                    cur = 0;
                }
                cur += weight;
            }
            if (need <= D) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        _4_26_ShipWithinDays test = new _4_26_ShipWithinDays();
        int b = test.shipWithinDays_BinarySearch(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
//        boolean b1 = test.checkWeight(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5, 10);

//        System.out.println(b1);
        System.out.println(b);
    }

}
