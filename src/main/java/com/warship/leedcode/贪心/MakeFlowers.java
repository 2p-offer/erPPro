package  com.warship.leedcode.贪心;

/**
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，
 * 能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 * 示例 1：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *
 * 提示：
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 */
public class MakeFlowers {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        if(length == 1 && flowerbed[0] == 0){
            return n < 2;
        }
        if(length > 1 && flowerbed[0] == 0 && flowerbed[1] ==0){
            flowerbed[0] = 1;
            n --;
        }
        for(int i =1 ;i < length -1 ;i ++){
            if(flowerbed[i-1] == 0 && flowerbed[i+1] == 0&& flowerbed[i] == 0){
                flowerbed[i] = 1;
                n --;
            }
            //为什么 <= 0 ?
            /**
             * 输入：
             * [0,0,0,0,0,1,0,0]
             * 0
             * 输出：
             * false
             * 预期：
             * true
             */
            if(n <= 0){
                return true;
            }
        }
        if(flowerbed[length - 1 ] == 0 && flowerbed[length - 2] ==0){
            return  n <= 1;
        }
        return n < 1;
    }

    public static void main(String[] args) {
        int[] test = new int[]{0,0,1,0,0,0,0};
        boolean b = MakeFlowers.canPlaceFlowers(test, 0);
        System.out.println(b);
    }


    /**
     * 官方解答
     */
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            int m = flowerbed.length;
            int prev = -1;
            for (int i = 0; i < m; i++) {
                if (flowerbed[i] == 1) {
                    if (prev < 0) {
                        count += i / 2;
                    } else {
                        count += (i - prev - 2) / 2;
                    }
                    prev = i;
                }
            }
            if (prev < 0) {
                count += (m + 1) / 2;
            } else {
                count += (m - prev - 1) / 2;
            }
            return count >= n;
        }
    }
}
