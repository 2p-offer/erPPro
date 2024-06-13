package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;

/**
 * 993. 二叉树的堂兄弟节点
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 * 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 * 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 * 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点数介于 2 到 100 之间。
 * 每个节点的值都是唯一的、范围为 1 到 100 的整数。
 */
public class _993_isCousins {
    //BFS 使用：
    LinkedList<TreeNode> queue = new LinkedList<>();
    boolean flag = false;
    int fatherNodeVal = 0;

    //DFS使用
    int xFather = 0;
    int xDepth = -1;

    int yFather = 0;
    int yDepth = -1;

    public boolean isCousins(TreeNode root, int x, int y) {
        //广度优先：
        queue.offer(root);
        return BFS(x, y);
    }

    public boolean isCousins_II(TreeNode root, int x, int y) {

        DFS(root, x, y, 1);
        return xDepth != -1 && xDepth == yDepth && xFather != yFather;
    }


    //广度优先  ，遍历每一层。
    //当一层出现 xy之一后，这一层没有再次出现x、y. 则返回失败。flag记录是否出现过一次xy
    //因为只能是堂兄。不能是兄弟，所以要记录父节点。当第二次出现xy时，父节点不能相同
    public boolean BFS(int x, int y) {

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.pop();

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                    if (currentNode.left.val == x || currentNode.left.val == y) {
                        if (flag) {
                            return fatherNodeVal != currentNode.val;
                        } else {
                            flag = true;
                            fatherNodeVal = currentNode.val;
                        }
                    }
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                    if (currentNode.right.val == x || currentNode.right.val == y) {
                        if (flag) {
                            return fatherNodeVal != currentNode.val;
                        } else {
                            flag = true;
                            fatherNodeVal = currentNode.val;
                        }
                    }
                }
            }
            if (flag) {
                return false;
            }
        }
        return false;
    }


    /**
     * 可能这个dfs还有很多优化的空间，比如在递归内部判断，如果xDepth 和 yDepth 已经被修改过，就不需要继续下去了。
     * 因为leedcode 内测试用例量级太低，所以bfs和dfs效率包括空间占用没有太大区别
     * @param root
     * @param x
     * @param y
     * @param depth
     */
    public void DFS(TreeNode root, int x, int y, int depth) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            if (root.left.val == x) {
                xDepth = depth;
                xFather = root.val;
            }

            if (root.left.val == y) {
                yDepth = depth;
                yFather = root.val;
            }

            DFS(root.left, x, y, depth + 1);
        }
        if (root.right != null) {
            if (root.right.val == x) {
                xDepth = depth;
                xFather = root.val;
            }

            if (root.right.val == y) {
                yDepth = depth;
                yFather = root.val;
            }
            DFS(root.right, x, y, depth + 1);
        }
    }

    public static void main(String[] args) {
        _993_isCousins test = new _993_isCousins();
        boolean cousins = test.isCousins(TreeNode.array2Tree(new Integer[]{1, 2, 3, null, 4, null, 5}), 5, 4);
        boolean cousinsII = test.isCousins_II(TreeNode.array2Tree(new Integer[]{1, 2, 3, null, 4, null, 5}), 5, 4);
        System.out.println(cousins);
        System.out.println(cousinsII);
    }

}