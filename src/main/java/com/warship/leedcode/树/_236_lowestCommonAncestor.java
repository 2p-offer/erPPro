package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 */
public class _236_lowestCommonAncestor {
    /**
     * 执行用时：
     * 258 ms
     * , 在所有 Java 提交中击败了
     * 5.55%
     * 的用户
     * 内存消耗：
     * 39.7 MB
     * , 在所有 Java 提交中击败了
     * 97.52%
     * 的用户
     */
    public TreeNode lowestCommonAncestor_self(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> conP = new LinkedList();
        LinkedList<TreeNode> conQ = new LinkedList();
        getPath(root, p, conP);
        getPath(root, q, conQ);
        for (TreeNode t1 : conP) {
            System.out.println(",," + t1.val);
        }

        System.out.println("11111111111111111111111");


        for (TreeNode t1 : conQ) {
            System.out.println(",," + t1.val);
        }
        TreeNode res = null;
        for (int i = 0; i < conP.size() && i < conQ.size(); ++i) {
            if (conP.get(i).val == conQ.get(i).val) {
                res = conP.get(i);
            } else {
                break;
            }
        }
        return res;
    }

    private boolean getPath(TreeNode node, TreeNode cur, LinkedList<TreeNode> con) {

        con.addLast(node);
        if (node.val == cur.val) {
            return true;
        }

        if (node.left != null && getPath(node.left, cur, con)) {
            return true;
        }
        if (node.right != null && getPath(node.right, cur, con)) {
            return true;
        }
        con.removeLast();
        return false;
    }


    /**
     *执行用时：
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 49.39%
     * 的用户
     * 内存消耗：
     * 40.1 MB
     * , 在所有 Java 提交中击败了
     * 93.98%
     * 的用户
     */
    private TreeNode ans;

    public TreeNode lowestCommonAncestor_DFS(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return false;
        }
        boolean isCur = root == p || root == q;
        boolean isLeft = dfs(root.left, p, q);
        boolean isRight = dfs(root.right, p, q);
        if ((isCur && (isLeft || isRight)) || isLeft && isRight) {
            ans = root;
        }
        return isCur || isLeft || isRight;
    }


    public static void main(String[] args) {
        TreeNode tree = TreeNode.array2Tree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        _236_lowestCommonAncestor test = new _236_lowestCommonAncestor();
        TreeNode treeNode = test.lowestCommonAncestor_self(tree, new TreeNode(2), new TreeNode(6));
        System.out.println(treeNode.val);

    }
}
