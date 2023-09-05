package com.warship.test.leedcode.daily._21_04;

/**
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 示例：
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * <p>
 * 提示：
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */
public class _4_14_Trie {

    public boolean isEnd;//当前节点，是否是最终节点
    public _4_14_Trie[] childs;

    /**
     * Initialize your data structure here.
     */
    public _4_14_Trie() {
        childs = new _4_14_Trie[26];
        isEnd = false;
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        _4_14_Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.childs[index] == null) {
                node.childs[index] = new _4_14_Trie();
            }
            node = node.childs[index];
        }
        node.isEnd = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        _4_14_Trie prefixEndNode = getPrefixEndNode(word);
        return prefixEndNode != null && prefixEndNode.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        _4_14_Trie prefixEndNode = getPrefixEndNode(prefix);
        return prefixEndNode != null;
    }

    private _4_14_Trie getPrefixEndNode(String prefix) {
        _4_14_Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.childs[index] == null) {
                return null;
            }
            node = node.childs[index];
        }
        return node;
    }

    public static void main(String[] args) {
        _4_14_Trie trie = new _4_14_Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("apple"));

        System.out.println(trie.startsWith("app"));
        System.out.println(trie.search("app"));
        trie.insert("app");

        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
