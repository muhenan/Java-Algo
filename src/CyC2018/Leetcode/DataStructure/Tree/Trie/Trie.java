package CyC2018.Leetcode.DataStructure.Tree.Trie;


/**
 * Trie，又称前缀树或字典树，用于判断字符串是否存在或者是否具有某种字符串前缀
 * 如图所示：https://github.com/CyC2018/CS-Notes/blob/master/notes/Leetcode%20%E9%A2%98%E8%A7%A3%20-%20%E6%A0%91.md#trie
 * 用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查
 *
 * 本题为实现一个 Trie，前缀树
 *
 * Leetcode_208_ImplementTrie
 *
 * */

public class Trie {
    /**
     * Trie() 初始化前缀树对象
     * void insert(String word) 向前缀树中插入字符串 word
     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false
     * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false
     *
     * */


    /**
     * Trie 的数据结构要存东西，肯定要有自己的 Node
     * 所以这里弄一个 private class Node
     * 这个 Node 结构也非常巧妙
     * 生成自己的时候直接开 26 个 子 Node来存其他的
     *
     * 并且有一个 isLeaf 来标明是否是叶子
     * */
    private class TrieNode {
        TrieNode[] childs = new TrieNode[26];
        boolean isLeaf;
    }

    private TrieNode root = new TrieNode();

    public Trie() {
    }

    public void insert(String word) {
        insert(word, root);
    }

    /**
     * 这里的 insert 是带上了 Node 的 insert
     * 这样就可以只解决一个字母的 insert 然后递归
     *
     * 如 insert wo，那么最后会有 三个 Node 空->w->o，其中 o 这个 node 的 isLeaf 是 true
     * 当有一个新字母时，new 一个新的 Node
     * */
    private void insert(String word, TrieNode trieNode) {
        if (trieNode== null) return;
        if (word.length() == 0) {
            trieNode.isLeaf = true;
            return;
        }
        int index = indexForChar(word.charAt(0));
        if (trieNode.childs[index] == null) {
            trieNode.childs[index] = new TrieNode();
        }
        insert(word.substring(1), trieNode.childs[index]);
    }

    /**
     * search 也是同样的道理，递归 search
     * 找到 isLeaf 为 true 的情况
     * */
    public boolean search(String word) {
        return search(word, root);
    }

    private boolean search(String word, TrieNode trieNode) {
        if (trieNode== null) return false;
        if (word.length() == 0) return trieNode.isLeaf;
        int index = indexForChar(word.charAt(0));
        return search(word.substring(1), trieNode.childs[index]);
    }

    /**
     * startsWith 和 search 类似但更简单，不用看 isLeaf 了，找到就直接返回 true
     * */
    public boolean startsWith(String prefix) {
        return startWith(prefix, root);
    }

    private boolean startWith(String prefix, TrieNode trieNode) {
        if (trieNode== null) return false;
        if (prefix.length() == 0) return true;
        int index = indexForChar(prefix.charAt(0));
        return startWith(prefix.substring(1), trieNode.childs[index]);
    }

    private int indexForChar(char c) {
        return c - 'a';
    }
}
