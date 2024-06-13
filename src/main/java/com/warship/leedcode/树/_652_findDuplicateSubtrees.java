package  com.warship.leedcode.树;

import  com.warship.leedcode.helper.TreeNode;

import java.util.*;

/**
 * 652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 */
public class _652_findDuplicateSubtrees {
    Map<String, Integer> count;
    List<TreeNode> ans;

    /**
     * 执行用时：
     * 19 ms
     * , 在所有 Java 提交中击败了
     * 91.27%
     * 的用户
     * 内存消耗：
     * 49.2 MB
     * , 在所有 Java 提交中击败了
     * 9.22%
     * 的用户
     *
     * @param root
     * @return
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        dfs(root);
        return ans;
    }

    public String dfs(TreeNode node) {
        if (node == null) return "#";
        StringBuilder decodeSb = new StringBuilder().append(node.val).append(",").append(dfs(node.left)).append(",").append(dfs(node.right));
        String decode = decodeSb.toString();
        System.out.println("dedede-------" + decode);
        count.put(decode, count.getOrDefault(decode, 0) + 1);
        if (count.get(decode) == 2) {
            ans.add(node);
        }
        return decode;
    }


    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 99.97%
     * 的用户
     * 内存消耗：
     * 39.4 MB
     * , 在所有 Java 提交中击败了
     * 99.32%
     * 的用户
     */
    HashMap<Integer, Integer> memo = new HashMap<>();
    LinkedList<TreeNode> list = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees_II(TreeNode root) {
        traverse(root);
        return list;
    }

    /**
     * 这个方法，给他牛逼坏了。。只看不懂啊。。
     *
     * @param root
     * @return
     */
    public int traverse(TreeNode root) {
        if (root == null) {
            return 3524335;
        }
        int left = traverse(root.left);
        int right = traverse(root.right);
        int result = ((left ^ 3) * 3423443 + (right ^ 13)) * 3423443 + root.val;

        int flag = memo.getOrDefault(result, 0);
        if (flag == 1) {
            list.add(root);
        }
        memo.put(result, flag + 1);
        return result;
    }


    public static void main(String[] args) {
        _652_findDuplicateSubtrees test = new _652_findDuplicateSubtrees();
        List<TreeNode> duplicateSubtrees = test.findDuplicateSubtrees(TreeNode.array2Tree(new Integer[]{2, 1, 11, 11, null, 1}));
        System.out.println(duplicateSubtrees);
    }
}
