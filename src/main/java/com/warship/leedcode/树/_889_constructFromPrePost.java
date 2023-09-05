package com.warship.test.leedcode.树;

import com.warship.test.leedcode.helper.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class _889_constructFromPrePost {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return dfs(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    private TreeNode dfs(int[] pre, int[] post, int pi, int pj, int qi, int qj) {

        if (pj < pi && qj < qi) {
            return null;
        }

        TreeNode ans = new TreeNode(pre[pi]);
        int inteval = 0;
        for (int i = qi; i < qj; i++) {
            if (post[i] == pre[pi + 1]) {
                inteval = i;
                break;
            }
        }
        int length = inteval - qi;
        ans.left = dfs(pre, post, pi + 1, pi + 1 + length, qi, inteval);
        ans.right = dfs(pre, post, pi + length + 2, pj, inteval + 1, qj - 1);
        return ans;
    }

    public static void main(String[] args) {
        _889_constructFromPrePost test = new _889_constructFromPrePost();
        TreeNode treeNode = test.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        System.out.println(treeNode);

        Map<Integer, Integer> map = new HashMap<>();
    }
}
