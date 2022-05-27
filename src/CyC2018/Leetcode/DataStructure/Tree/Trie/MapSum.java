package CyC2018.Leetcode.DataStructure.Tree.Trie;

/**
 * Node 中加了值 这里的 value 会被初始化为 0，所以不用担心，这个 value 就已经能代表是不是 leaf 了
 * （Node 也会初始化为 null，Java 的好处！）
 * insert 和之前基本一样
 * 重点看 sum
 * */
public class MapSum {
    private class Node {
        Node[] child = new Node[26];
        int value;
    }

    private Node root = new Node();

    public MapSum() {

    }

    public void insert(String key, int val) {
        insert(key, root, val);
    }

    private void insert(String key, Node node, int val) {
        if (node == null) return;
        if (key.length() == 0) {
            node.value = val;
            return;
        }
        int index = indexForChar(key.charAt(0));
        if (node.child[index] == null) {
            node.child[index] = new Node();
        }
        insert(key.substring(1), node.child[index], val);
    }

    public int sum(String prefix) {
        return sum(prefix, root);
    }

    private int sum(String prefix, Node node) {
        if (node == null) return 0;
        if (prefix.length() != 0) {
            int index = indexForChar(prefix.charAt(0));
            return sum(prefix.substring(1), node.child[index]);
        }
        int sum = node.value;
        for (Node child : node.child) {
            sum += sum(prefix, child); // 这里带进去的 prefix 就是长度为 0 了，空串进去的话，就是加加加了把下面所有子树以 dfs 的方式都加上 val
        }
        return sum;
    }

    private int indexForChar(char c) {
        return c - 'a';
    }
}
