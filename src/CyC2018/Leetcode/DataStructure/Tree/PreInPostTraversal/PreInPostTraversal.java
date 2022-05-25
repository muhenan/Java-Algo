package CyC2018.Leetcode.DataStructure.Tree.PreInPostTraversal;

import CyC2018.Leetcode.DataStructure.Tree.TreeNode;

/**
 *     1
 *    / \
 *   2   3
 *  / \   \
 * 4   5   6
 *
 *
 * 层次遍历顺序：[1 2 3 4 5 6]
 * 前序遍历顺序：[1 2 4 5 3 6]
 * 中序遍历顺序：[4 2 5 1 3 6]
 * 后序遍历顺序：[4 5 2 6 3 1]
 *
 * 层次遍历使用 BFS 实现，利用的就是 BFS 一层一层遍历的特性；而前序、中序、后序遍历利用了 DFS 实现。
 *
 * 前序、中序、后序遍只是在对节点访问的顺序有一点不同，其它都相同。
 * */

public class PreInPostTraversal {

    // pre
    void dfs(TreeNode root) {
        visit(root);
        dfs(root.left);
        dfs(root.right);
    }

    // in
    void dfs2(TreeNode root) {
        dfs2(root.left);
        visit(root);
        dfs2(root.right);
    }

    // post
    void dfs3(TreeNode root) {
        dfs3(root.left);
        dfs3(root.right);
        visit(root);
    }

    private void visit(TreeNode root) { return;}
}
