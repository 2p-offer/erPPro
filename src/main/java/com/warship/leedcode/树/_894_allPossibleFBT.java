package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 894. 所有可能的满二叉树
 * 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * 答案中每个树的每个结点都必须有 node.val=0。
 * 你可以按任何顺序返回树的最终列表。
 */
public class _894_allPossibleFBT {

    Map<Integer, List<TreeNode>> container = new HashMap();

    /**
     * 执行用时：
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 12.68%
     * 的用户
     * 内存消耗：
     * 40.9 MB
     * , 在所有 Java 提交中击败了
     * 38.74%
     * 的用户
     *
     * @param n
     * @return
     */
    public List<TreeNode> allPossibleFBT(int n) {


        List<TreeNode> ans = new LinkedList<>();
        if (n == 1) {
            ans.add(new TreeNode(0));
            return ans;
        }
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftList;
            List<TreeNode> rightList;
            if (container.containsKey(i)) {
                leftList = container.get(i);
                rightList = container.get(n - i - 1);
            } else {
                leftList = allPossibleFBT(i);
                rightList = allPossibleFBT(n - 1 - i);
                container.put(i, leftList);
                container.put(n - 1 - i, rightList);
            }
            for (int l = 0; l < leftList.size(); l++) {
                for (int r = 0; r < rightList.size(); r++) {
                    TreeNode root = new TreeNode(0, leftList.get(l), rightList.get(r));
                    ans.add(root);
                }
            }

        }
        return ans;

    }

    Map<Integer, List<TreeNode>> memo = new HashMap();

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 40.6 MB
     * , 在所有 Java 提交中击败了
     * 70.66%
     * 的用户
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT_Main(int N) {
        if (!memo.containsKey(N)) {
            List<TreeNode> ans = new LinkedList();
            if (N == 1) {
                ans.add(new TreeNode(0));
            } else if (N % 2 == 1) {
                for (int x = 0; x < N; ++x) {
                    int y = N - 1 - x;
                    for (TreeNode left : allPossibleFBT(x))
                        for (TreeNode right : allPossibleFBT(y)) {
                            TreeNode bns = new TreeNode(0);
                            bns.left = left;
                            bns.right = right;
                            ans.add(bns);
                        }
                }
            }
            memo.put(N, ans);
        }

        return memo.get(N);
    }


}
