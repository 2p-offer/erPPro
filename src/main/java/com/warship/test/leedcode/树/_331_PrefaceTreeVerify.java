package com.warship.test.leedcode.树;

/**
 * 331. 验证二叉树的前序序列化
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * <p>
 * 示例 1:
 * 输入: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "1,#"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: "9,#,#,1"
 * 输出: false
 */
public class _331_PrefaceTreeVerify {

    public static boolean isValidSerialization(String preorder) {
        if("#".equals(preorder)){
            return  true;
        }
        if(preorder.length() < 5){
            return  false;
        }
        if (!"#,#".equals(preorder.substring(preorder.length() - 3))) {
            return false;
        }
        return doValid(preorder);
    }

    public static boolean doValid(String preorder) {
        System.out.println(preorder);
        if ("#".equals(preorder)) {
            return true;
        }
        String s = preorder.replaceAll("[0-9]{1,}(,#,#)", "#");
        if(s.equals(preorder)){
            return false;
        }
        return doValid(s);

    }

    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        boolean validSerialization = isValidSerialization(preorder);
        System.out.println(validSerialization);
    }


    /**
     * 更好的解法吧。。
     */
    int pos = 0;
    public boolean isValidSerialization2(String preorder) {
        pos = 0;
        return dfs(preorder) && pos >= preorder.length();
    }

    public boolean dfs(String preorder) {
        if (pos >= preorder.length()) {
            return false;
        }
        if (preorder.charAt(pos) == '#') {
            pos += 2;
            return true;
        }
        while (pos < preorder.length() && Character.isDigit(preorder.charAt(pos))) {
            pos++;
        }
        pos++;
        return dfs(preorder) && dfs(preorder);
    }
}
