package  com.warship.leedcode.daily._21_04;

import  com.warship.leedcode.helper.TreeNode;

/**
 * 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 示例 2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 * <p>
 * 提示：
 * 树中节点数的取值范围是 [1, 100]
 * 0 <= Node.val <= 1000
 */
public class _4_25_IncreasingBST {
    TreeNode tmp = null;
    TreeNode head = null;

    public TreeNode increasingBST(TreeNode root) {
        dealNode(root);
        tmp.left = null;
        return head;

    }

    private void dealNode(TreeNode root) {
        if (root == null) {
            return;
        }
        dealNode(root.left);
        if (tmp != null) {
            tmp.right = root;
            tmp.left = null;
            tmp = root;
        } else {
            tmp = root;
        }
        if (head == null) {
            head = root;
        }
        dealNode(root.right);
    }


    /**
     * 官方题解很不错，
     * 首先我的head 他新建一个新节点，省略了我很多判断
     * 其次：
     * 我的 tmp.left = null; 官方是 root.left = null; 省略我递归后，返回结果前的 tmp.left = null;
     * 这些都很细节
     */
    private TreeNode resNode;

    public TreeNode increasingBST_main(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder(node.right);
    }


    public static void main(String[] args) {
        _4_25_IncreasingBST test = new _4_25_IncreasingBST();
        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t3 = new TreeNode(3, null, null);
        TreeNode t4 = new TreeNode(4, t3, null);

        TreeNode t2 = new TreeNode(2, t1, t4);
//        TreeNode t7 = new TreeNode(7, null, null);
//        TreeNode t9 = new TreeNode(9, null, null);
//        TreeNode t8 = new TreeNode(8, t7, t9);
//        TreeNode t6 = new TreeNode(6, null, t8);
//        TreeNode t5 = new TreeNode(5, t3, t6);
        test.increasingBST_main(t2);
    }
}
