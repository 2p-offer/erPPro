package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * <p>
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * <p>
 * 示例 1：
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 * <p>
 * 提示：
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 1000
 * nums 中的所有整数 互不相同
 */
public class _654_constructMaximumBinaryTree {

    /**
     * 执行用时：
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 99.56%
     * 的用户
     * 内存消耗：
     * 38.7 MB
     * , 在所有 Java 提交中击败了
     * 33.23%
     * 的用户
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree_Self(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (end - start < 0) {
            return null;
        }
        int maxIndex = getMaxIndex(nums, start, end);
        TreeNode cuNode = new TreeNode(nums[maxIndex]);
        cuNode.left = dfs(nums, start, maxIndex - 1);
        cuNode.right = dfs(nums, maxIndex + 1, end);
        return cuNode;
    }

    private int getMaxIndex(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ans = i;
            }
        }
        return ans;
    }

    /**
     * 单调栈 写法。
     * 遍历nums。如果栈是空的，则把当前元素curNode 入栈
     * 如果栈不为空，栈顶元素topNode
     * 1.topNode > curNode curNode 入栈
     * 2.topNode < curNode ,弹出topNode，定义栈顶元素为 tNode（此时 topNode< tNode && topNode < curNode）
     * 3.比较tNode 与 curNode
     * - tNode < curNode
     * 弹出 tNode，作为 topNode 的父节点，并且topNode 指向tNode,
     * 栈顶元素为 tNode;
     * 重复上面动作直到如下；
     * - tNode > curNode
     * curNode 作为 topNode 的父节点。并将curNode 入栈
     * <p>
     * 直至nums遍历完毕。
     * 清空栈，顺序弹出栈顶元素（自顶向下递增），作为父节点
     * <p>
     * <p>
     * 执行用时：
     * 17 ms
     * , 在所有 Java 提交中击败了
     * 5.01%
     * 的用户
     * 内存消耗：
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 10.27%
     * 的用户
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree_Stack(int[] nums) {
        Stack<TreeNode> container = new Stack<>();
        int length = nums.length;
        TreeNode curNode = null;
        TreeNode topNode = null;
        TreeNode tNode = null;
        for (int i = 0; i < length; i++) {
            curNode = new TreeNode(nums[i]);
            while (!container.isEmpty()) {
                topNode = container.peek();
                if (curNode.val < topNode.val) {
                    break;
                }
                topNode = container.pop();
                if (!container.isEmpty()) {
                    tNode = container.peek();
                    if (tNode.val < curNode.val) {//tNode 是父节点
                        tNode = container.pop();
                        tNode.right = topNode;
                        container.push(tNode);
                        continue;
                    } else {//curNode 是父节点
                        curNode.left = topNode;
                        break;
                    }
                } else {//如果是空，
                    curNode.left = topNode;
                    break;
                }
            }
            container.push(curNode);
        }

        curNode = null;
        if (!container.isEmpty()) {
            curNode = container.pop();
        }
        while (!container.isEmpty()) {
            topNode = container.pop();
            topNode.right = curNode;
            curNode = topNode;

        }
        return curNode;
    }


    /**
     * 题解里面别人的单调栈，比我优雅，那不是一点半点
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree_Stack_II(int[] nums) {
        TreeNode root = null, node = null;
        LinkedList<TreeNode> stack = new LinkedList<>();

        for (int i = 0; i < nums.length; ++i) {
            node = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peek().val < node.val) {
                // 出栈 - 栈顶是左边第一个大的值, node是右边第一个大的值
                root = stack.pop();

                // 条件2、3
                if (stack.isEmpty() || stack.peek().val > node.val) {
                    node.left = root;
                } else {
                    stack.peek().right = root;
                }
            }

            // 入栈
            stack.push(node);
        }

        // 只有一个: 左边第一个大的
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (!stack.isEmpty()) {
                // 条件3
                stack.peek().right = root;
            }
        }

        // 最后出栈的就是root
        return root;
    }

    public static void main(String[] args) {
        _654_constructMaximumBinaryTree test = new _654_constructMaximumBinaryTree();
        TreeNode treeNode = test.constructMaximumBinaryTree_Stack(new int[]{3, 2, 1, 6, 0, 5});
        System.out.println(treeNode);
    }

}
