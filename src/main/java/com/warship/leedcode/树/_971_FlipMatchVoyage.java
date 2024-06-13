package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 * 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
 * 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
 * 通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：
 * 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
 * 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
 *
 * 示例 1：
 * 输入：root = [1,2], voyage = [2,1]
 * 输出：[-1]
 * 解释：翻转节点无法令先序遍历匹配预期行程。
 *
 * 示例 2：
 * 输入：root = [1,2,3], voyage = [1,3,2]
 * 输出：[1]
 * 解释：交换节点 2 和 3 来翻转节点 1 ，先序遍历可以匹配预期行程。
 *
 * 示例 3：
 * 输入：root = [1,2,3], voyage = [1,2,3]
 * 输出：[]
 * 解释：先序遍历已经匹配预期行程，所以不需要翻转节点。
 *
 * 提示：
 * 树中的节点数目为 n
 * n == voyage.length
 * 1 <= n <= 100
 * 1 <= Node.val, voyage[i] <= n
 * 树中的所有值 互不相同
 * voyage 中的所有值 互不相同
 *
 *
 *
 */
public class _971_FlipMatchVoyage {
    List<Integer> res = new ArrayList<>();
    int index = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (!dealNode(root, voyage, 0)) {
            res.clear();
            res.add(-1);
            return res;
        }
        return res;
    }

    private boolean dealNode(TreeNode node, int[] voyage, int i) {
//        System.out.println("index:" + index);
//        System.out.println("nodeval:" + node.val + ",i:" + i);
        if (node.val != voyage[i]) {
            return false;
        }
        index = i;
        if (index == voyage.length - 1) {
            return true;
        }
        if (node.right == null && node.left == null) {
            return true;
        }
        if (node.right != null && node.right.val == voyage[i + 1]) {
            if (!dealNode(node.right, voyage, i + 1)) {
                return false;
            }
            if (node.left == null) {
                return true;
            }
            res.add(node.val);
            return dealNode(node.left, voyage, index + 1);
        }
        return node.left != null && dealNode(node.left, voyage, i + 1) && (node.right == null || dealNode(node.right, voyage, index + 1));
    }

    public static void main(String[] args) {
        _971_FlipMatchVoyage test = new _971_FlipMatchVoyage();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, null));
        List<Integer> integers = test.flipMatchVoyage(root, new int[]{1, 2});
        System.out.println(integers);
    }

}
