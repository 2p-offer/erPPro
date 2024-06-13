package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 *
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7
 *
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class _450_deleteNode {


    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 61.39%
     * 的用户
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode_self(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        TreeNode preNode = new TreeNode(root.val - 1);
        TreeNode head = preNode;
        preNode.right = root;
        boolean isRight = true;
        while (root != null) {
            if (key == root.val) {
                if (root.left == null) {//如果左节点是空，直接把右节点顶上来
                    if (isRight) {
                        preNode.right = root.right;
                    } else {
                        preNode.left = root.right;
                    }
                    break;
                }
                if (root.right == null) {//如果右节点是空，直接把左节点顶上来
                    if (isRight) {
                        preNode.right = root.left;
                    } else {
                        preNode.left = root.left;
                    }
                    break;
                }
                //找到左子树中最大的，当做右子树的父亲【保持二叉搜索树特性】（左子树最大值的右节点指向右子树）
                if (isRight) {
                    preNode.right = root.left;
                } else {
                    preNode.left = root.left;
                }
                TreeNode cuNode = root.left;
                while (cuNode.right != null) {
                    cuNode = cuNode.right;
                }
                cuNode.right = root.right;
                break;

            }
            preNode = root;
            if (key > root.val) {
                root = root.right;
                isRight = true;
            } else if (key < root.val) {
                root = root.left;
                isRight = false;
            }
        }
        return head.right;
    }


    /*
One step right and then always left
*/
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null) root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }

    /**
     * 执行用时：
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 20.43%
     * 的用户
     * <p>
     * 递归的方式。
     *
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val) root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val) root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }


    public static void main(String[] args) {
        _450_deleteNode test = new _450_deleteNode();
        TreeNode treeNode = test.deleteNode(TreeNode.array2Tree(new Integer[]{5, 3, 6, 2, 4, null, 7}), 0);
        System.out.println(treeNode);
    }
}
