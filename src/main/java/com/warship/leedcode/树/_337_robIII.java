package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * 通过次数107,571提交次数175,951
 */
public class _337_robIII {

    /**
     * 执行用时：
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 11.91%
     * 的用户
     * 内存消耗：
     * 37.7 MB
     * , 在所有 Java 提交中击败了
     * 96.44%
     * 的用户
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        Map<TreeNode, Integer> dpf = new HashMap<>();
        Map<TreeNode, Integer> dpg = new HashMap<>();
        //我们设f(x) 是当x节点被选中时，最大收益，
        //设G(x)是当x节点未被选择是，最大收益。
        //状态转移方程
        //dp[X] = Max(f(x),G(x))
        //f(x) = G(x.left) + G(x.right) + x.val;//x被选。意味着本身的值+ 左右子节点未被选中的值
        //G(x) = max(G(x.left),f(x.left))+ max(G(x.right),f(x.right)) //x未被选，左右子节点都可以被选择。选择左右子节点是不是被选择的最大值

        //base case：
        //叶子结点(x.left == null && x.right == null)
        //f(x) = x.val;
        //G(x) = 0;
        dfs(root, dpf, dpg);
        return Math.max(dpf.get(root), dpg.get(root));
    }

    private void dfs(TreeNode node, Map<TreeNode, Integer> dpf, Map<TreeNode, Integer> dpg) {
        if (node.left == null && node.right == null) {
            dpf.put(node, node.val);
            dpg.put(node, 0);
            return;
        }
        if (node.left != null) {
            dfs(node.left, dpf, dpg);
        }
        if (node.right != null) {
            dfs(node.right, dpf, dpg);
        }
        dpf.put(node, dpg.getOrDefault(node.left, 0) + dpg.getOrDefault(node.right, 0) + node.val);
        dpg.put(node, Math.max(dpg.getOrDefault(node.left, 0), dpf.getOrDefault(node.left, 0)) + Math.max(dpg.getOrDefault(node.right, 0), dpf.getOrDefault(node.right, 0)));
    }


    /**
     * 官方的一个解法。
     * 因为一个节点的值 只与 他的左右子节点有关。所以需要返回一个两个子节点的值就够了
     * @param root
     * @return
     */
    public int rob_main(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
