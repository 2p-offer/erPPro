package  com.warship.leedcode.daily._21_04;

import java.util.Arrays;

/**
 * 27. 移除元素
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 说明:
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 你可以想象内部操作如下:
 * // nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
 * int len = removeElement(nums, val);
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 示例 1：
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 *
 * 示例 2：
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 * 提示：
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public class _4_19_RemoveDuplicates {

    /**
     * 自己的想法，借用了一个-1 来标识currentIndex 状态。其实完全用不到
     * 只要nums[i] ！= val  直接 nums[currentIndex++] = nums[i]
     * 像 removeElement_II 这样
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeDuplicates(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int currentIndex = -1;
        for (int i = 0; i < length; i++) {
            if (nums[i] == val && currentIndex == -1) {
                currentIndex = i;
            }
            if (nums[i] != val && currentIndex != -1) {
                nums[currentIndex++] = nums[i];

            }
        }
        return currentIndex == -1 ? length : currentIndex;
    }


    public int removeElement_II(int[] nums, int val) {
        int n = nums.length;
        int currentIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                nums[currentIndex] = nums[i];
                currentIndex++;
            }
        }
        return currentIndex;
    }


    /**
     * 官方的优化思路。   改变nums[i] 的值的频率降低（尤其nums 前面值与val相等时）
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeDuplicates_Main(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[--right];
            } else {
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 1, 1, 2, 3, 4, 4, 5};
        nums = new int[]{2, 2, 2, 2};
        int i = removeDuplicates(null, 3);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));


    }
}
