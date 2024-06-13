package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class _102_levelOrder {

    /**
     * 广度优先，还是强调一编，container集合使用队列/链表 远比 数组类别的数据结构要好。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> container = new LinkedList();

        container.offer(root);
        while (!container.isEmpty()) {
            int size = container.size();
            List<Integer> tmpList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmpNode = container.poll();
                tmpList.add(tmpNode.val);
                if (tmpNode.left != null)
                    container.offer(tmpNode.left);
                if (tmpNode.right != null)
                    container.offer(tmpNode.right);
            }
            res.add(tmpList);
        }
        return res;
    }

    public static void main(String[] args) {

        Integer[] tmp = new Integer[]{1, 2, 3, 4, 5, 6, null, 7, null, 8, 9, null, 11, 10};
        System.out.println(Arrays.toString(tmp));

        _102_levelOrder test = new _102_levelOrder();
        List<List<Integer>> lists = test.levelOrder(TreeNode.array2Tree(tmp));
        System.out.println(lists);
        /*
                    1
            2            3
         4     5      6  null
        7 n   8 9   null null
       0
         */
    }
}
