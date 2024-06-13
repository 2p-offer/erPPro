package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 101. 对称二叉树
 * 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class _101_isSymmetric {


    //==============BFS============

    public boolean isSymmetric_I(TreeNode root) {

        return BFS(root);

    }

    /**
     * bfs,if else 大法，效率超低。。
     * 层序遍历，在每一层判断每一层正过来反过来一样，到最后一层都合理，说明没问题
     *
     * @param node
     * @return
     */
    private boolean BFS(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> tmp = new LinkedList<>();
        queue.offer(node);
        boolean tag = true;
        while (tag && !queue.isEmpty()) {
            tag = false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (size > 1) {
                    if (i < size / 2) {
                        tmp.addFirst(current);
                    } else {
                        TreeNode currentTmp = tmp.poll();
                        if (current == null && current == currentTmp) {
                            continue;
                        }
                        if (current == null || null == currentTmp) {
                            return false;
                        }

                        if (current.val != currentTmp.val) {
                            return false;
                        }
                    }
                }
                if (current != null) {
                    if (current.left != null || current.right != null) {
                        tag = true;
                    }
                    queue.offer(current.left);
                    queue.offer(current.right);
                }
            }
        }
        return true;
    }


    //==================DFS==============


    Queue<Integer> list = new LinkedList<>();


    /**
     * 不好使。[1, 2, 2, 2, null, 2] 这个例子过不了。如果硬要用这种方式，就要提前计算数的深度，在第一次处理时，最后一层全由nil节点组成的不计入。
     * 但是，这不是好的办法。。
     *
     * @param root
     * @return
     */
    @Deprecated
    public boolean isSymmetric_II(TreeNode root) {

        DFS(root);
        System.out.println(list);
        return DFS2(root);

    }

    private void DFS(TreeNode node) {
        if (node == null) {
            list.add(null);
            return;
        }
        DFS(node.left);
        list.add(node.val);
        DFS(node.right);
    }

    private boolean DFS2(TreeNode node) {
        if (node == null) {
            return list.poll() == null;
        }
        if (!DFS2(node.right)) {
            return false;
        }
        if (node.val != list.poll()) {
            return false;
        }

        return DFS2(node.left);
    }


    /**
     * 两个指针 q p 当q往左走，p就往右走。直到 q == p == null 则 是对称树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_III(TreeNode root) {

        return dealPQ(root.left, root.right);

    }

    private boolean dealPQ(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }
        return left.val == right.val && dealPQ(left.left, right.right) && dealPQ(left.right, right.left);
    }


    public static void main(String[] args) {
        _101_isSymmetric test = new _101_isSymmetric();
//        boolean symmetric = test.isSymmetric_II(TreeNode.array2Tree(new Integer[]{2, 3, 3, 4, 5, 5, 4, null, null, 8, 9, null, null, 9, 8}));
//        boolean symmetric2 = test.isSymmetric_II(TreeNode.array2Tree(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
        boolean symmetric2 = test.isSymmetric_II(TreeNode.array2Tree(new Integer[]{1, 2, 2, 2, null, 2}));

//        System.out.println(symmetric);
        System.out.println(symmetric2);


    }
}
