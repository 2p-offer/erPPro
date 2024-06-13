package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [3,2,1]
 */
public class _145_postorderTraversal {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 54.27%
     * 的用户
     * 内存消耗：
     * 36.8 MB
     * , 在所有 Java 提交中击败了
     * 26.84%
     * 的用户
     * <p>
     * 自己的迭代后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> container = new LinkedList();
        container.offer(root);
        while (!container.isEmpty()) {
            TreeNode cuNode = container.pop();
            res.addFirst(cuNode.val);

            if (cuNode.left != null) {
                container.push(cuNode.left);
            }
            if (cuNode.right != null) {
                container.push(cuNode.right);
            }
        }
        return res;
    }


    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 54.27%
     * 的用户
     * 内存消耗：
     * 36.8 MB
     * , 在所有 Java 提交中击败了
     * 30.59%
     * 的用户
     * <p>
     * 官方的后序遍历，精华不在于 快，或者内存节省 。 而在于思想。并没有用java里面的双端队列实现。
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_Main(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal_0621(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> container = new Stack<>();
        TreeNode pre = null;//用来判断右节点是否已经遍历过
        while (root != null || !container.isEmpty()) {
            while(root != null){
                container.push(root);
                root = root.left;
            }
            root = container.pop();//走到这里说明root.left == null;
            if(root.right == null || root.right == pre){//到这里，要么右节点是空，要么右节点被遍历过，才能处理当前节点
                ans.add(root.val);
                pre = root;//记录当前处理节点， 防止走到右子树
                root = null;//处理完当前节点，要置空，防止再次走到左子树
            }else {
                container.push(root);//当前节点右节点未处理，要入栈，然后处理右节点
                root = root.right;
            }

        }
        return ans;
    }

}
