package  com.warship.leedcode.BFS;

import  com.warship.leedcode.helper.TreeNode;

import java.util.LinkedList;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 *
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 */
public class _111_MinDepth {
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> lujing = new LinkedList<TreeNode>();//里面放置目前可以作为出发点的节点
        lujing.offer(root);
        int res = 1;
        while(!lujing.isEmpty()){
            int size = lujing.size();
            for(int i = 0 ; i < size ;i ++){//遍历所有情况
                TreeNode cur = lujing.pop();
                if(cur.left == null && cur.right == null){
                    return res;
                }
                if(cur.left!=null){
                    lujing.offer(cur.left);
                }

                if(cur.right!=null){
                    lujing.offer(cur.right);
                }
            }
            res++;

        }
        return res;
    }
}
