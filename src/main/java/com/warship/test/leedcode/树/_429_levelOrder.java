package com.warship.test.leedcode.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N 叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 *
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 *
 * 提示：
 *
 * 树的高度不会超过 1000
 * 树的节点总数在 [0, 10^4] 之间
 */
public class _429_levelOrder {

    /**
     * 执行用时：
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 55.91%
     * 的用户
     * 内存消耗：
     * 39.2 MB
     * , 在所有 Java 提交中击败了
     * 72.08%
     * 的用户
     * @param root
     * @return
     */
/*    public List<List<Integer>> levelOrder_BFS(Node root) {
        List<List<Integer>> ans = new LinkedList();
        if(root == null){
            return ans;
        }
        Queue<Node> container = new LinkedList();
        container.offer(root);
        while(!container.isEmpty()){
            int size = container.size();
            List<Integer> tmpAns = new LinkedList();
            for(int i = 0 ; i < size;i++){
                Node node = container.poll();
                tmpAns.add(node.val);
                if(node.children != null){
                    container.addAll(node.children);
                }
            }
            ans.add(tmpAns);
            tmpAns= new LinkedList();
        }
        return ans;
    }*/


    /**
     *执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.97%
     * 的用户
     * 内存消耗：
     * 39.2 MB
     * , 在所有 Java 提交中击败了
     * 71.44%
     * 的用户
     */
    private List<List<Integer>> result = new ArrayList<>();

/*    public List<List<Integer>> levelOrder_DFS(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }

    private void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }*/



}
