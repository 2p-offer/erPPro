package  com.warship.leedcode.daily._21_03;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
 * <p>
 * 进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？
 * <p>
 * 示例 1：
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 解释：序列中不存在 132 模式的子序列。
 * <p>
 * 示例 2：
 * 输入：nums = [3,1,4,2]
 * 输出：true
 * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
 * <p>
 * 示例 3：
 * 输入：nums = [-1,3,2,0]
 * 输出：true
 * 解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
 * <p>
 * 提示：
 * n == nums.length
 * 1 <= n <= 104
 * -109 <= nums[i] <= 109
 */
public class _3_24_Find132pattern {

    /**
     * 1.初看这道题感觉不难但捉不到思路。当然有一种做法可以不让你拿0分，那就是三重循环分析遍所有的组合（笑）。这肯定是不可取的。我们试着简化这个问题的描述。直觉上感觉这个问题变化的量太多，a[i]、a[j]、a[k]都在变化，我们试着固定一个数。我们选择固定a[j]，因为a[j]在次序上处于中间，可以确定另两个数的范围。那这样问题就变为在a[j]的左边找到一个数比它小的数a[i]，右边找到一个比它小的数a[k]，满足a[i]<a[k]。那么我们可以挑选a[j]左边的最小值和a[j]右边的最大值（前提都需要小于a[j]）作为a[i]和a[k]进行比较。假如这样子都无法满足a[i]<a[k]的条件那显然是无解的。
     * <p>
     * 2.经过上述分析，问题从三层循环简化到了两层循环（一层对j循环，一层扫描数组寻找最小值与最大值），但显然还是不够简化。因为在第二层循环耗费了太多时间，对每一个j都找一遍最小值和最大值太浪费时间。我们思考可不可以通过引入额外的记录空间的方式进行优化（以空间换时间）。对于最小值比较简单，我们可以建立一个数组min，min[j]代表a[j]左侧的数中的最小值。注意这里我们可以没有要求min[j]比a[j]小（否则是无法在O(n)内实现的），因为我们之后还需要对j扫描，完全可以在那时加入判断，只取min[j]<a[j]的情况。在这种情况下min[j]就是a[j]左侧比a[j]小的数中的最小值了。
     * <p>
     * 3.而对于最大值则稍微复杂，它并不能套用上面的方法，因为对于最小值，min[j]>=a[j]时一定不存在我们要找的最小值（因为a[j]左侧就没有比它小的数了）。而max[j]>=a[j]时，是可能有我们需要的最大值的，只是这个最大值被一个a[j]右端大于a[j]的数掩盖了。考虑到最大值需要从右端开始扫描，我们可以建立一个栈，把从右端扫描过来的数据都压入栈中（使用栈是因为需要先进后出）。对于这个栈的要求是，当循环到a[j]时先将其与栈顶的数比较，如果栈空或者比栈顶的数小便将其压栈（基于这条规则可以推出这个栈本身是自顶到底递增的，a[j]若小于栈顶的数，证明a[j]小于之前扫描过的所有数，并不是我们所需要的）。当a[j]大于栈顶的数时，便开始将小于a[j]的数全部弹栈，之后再将a[j]压入栈。因为之前已经说明了这个栈自顶到底是递增的，扫描又是从右端开始的，所以最后一个被弹出来的数便是a[j]右侧比a[j]小的数中的最大值了。
     * <p>
     * 4.有了这两个数据，基本也就大功告成了，只需让两者比较大小关系，满足ai<ak即可。这里我们把最大值和最小值都求出来进行了求解。更优化的方案可以不求最小值，因为在求最大值的过程中确定了a[j]与a[k]后，只需继续向前找，找到一个符合条件的a[i]即可，并不一定非要找到最小的。但是为了思路的清晰，参考程序中依然给出了有最小值的版本。
     *
     * @param nums
     * @return
     */


    public static boolean find132pattern1(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i-1], min[i - 1]);
        }
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.empty() && nums[j] > stack.peek()) {
                    max = stack.pop();
                }
                if (max > min[j]) {
                    return true;
                }
            }
            stack.push(nums[j]);
        }
        return false;
    }


    public static boolean find132pattern_xzj(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        LinkedList<Integer> start = new LinkedList<>();
        LinkedList<Integer> max = new LinkedList<>();
        int cur = nums[0];
        int curMax = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (cur > nums[i]) {
                if (cur > curMax) {
                    cur = nums[i];
                    continue;
                } else {
                    start.addFirst(cur);
                    max.addFirst(curMax);
                    cur = nums[i];
                    curMax = Integer.MIN_VALUE;
                }
            }
            if (cur < nums[i]) {
                if (curMax > nums[i]) {
                    return true;
                }
                curMax = nums[i];
            }
            while (start.size() > 0 && start.getFirst() < nums[i] && max.getFirst() != nums[i]) {
                if (max.getFirst() > nums[i]) {
                    return true;
                }
                if (nums[i] > max.getFirst()) {
                    max.pop();
                    start.pop();
                }

            }
        }
        return false;
    }

    /**
     * 官方题解
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }

    /**
     * 这个是自己写的，也是最容易想到的，两层循环
     *
     * @param nums
     * @return
     */
    public static boolean find132pattern_self(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        int iNum = 0;
        int jNum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            iNum = nums[i];
            jNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > iNum && nums[j] > jNum) {
                    jNum = nums[j];
                    continue;
                }
                if (nums[j] > iNum && nums[j] < jNum) {
                    System.out.println(iNum + ".." + jNum + ".." + nums[j]);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean find132pattern_Stack_self(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            mins[i] = Math.min(mins[i - 1], nums[i - 1]);
        }
        Stack<Integer> stack = new Stack<>();
        int rightMax = Integer.MIN_VALUE;
        for (int j = nums.length - 1; j > 0; j--) {
            if (nums[j] > mins[j]) {
                while (!stack.isEmpty() && nums[j] > stack.peek()) {
                    rightMax = stack.pop();
                }
                if (rightMax > mins[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        find132pattern1(new int[]{-1, 3, 2, 0, -2, 3});
    }
}
