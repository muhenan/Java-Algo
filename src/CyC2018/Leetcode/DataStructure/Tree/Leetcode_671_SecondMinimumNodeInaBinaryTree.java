package CyC2018.Leetcode.DataStructure.Tree;

/** easy 题，这题很简单，放松一下头脑了
 * */
public class Leetcode_671_SecondMinimumNodeInaBinaryTree {
    int []mins = new int []{-1, -1};
    public int findSecondMinimumValue(TreeNode root) {
        mins[1] = root.val;
        dfs(root);
        return mins[0];
    }
    private void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val < mins[1]) { // 找到了新的最小值，之前找的两个往前推
            mins[0] = mins[1];
            mins[1] = root.val;
        }
        // 在还没有第二小的情况下找到了第二小的值 || 确实是找到了新的夹在之前两个数之间的新的第二小的数
        else if ((mins[0] == -1 && root.val != mins[1]) || (root.val > mins[1] && root.val < mins[0])) mins[0] = root.val;
        dfs(root.left);
        dfs(root.right);
    }
}
