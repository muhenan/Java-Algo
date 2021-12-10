package ByteDanceTree;

import java.util.*;

public class Solution {

    // 103. 二叉树的锯齿形层序遍历
    // 变化的层次遍历，正常是队列，这里是栈，而且加了一个布尔flag，控制是不是从左开始放
    // 非常简单，正常的层次遍历变化了一点
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        boolean fromLeft = false;
        if (root == null) {
            return ans;
        }
        //Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        List<Integer> oneOfAns = new LinkedList<Integer>();
        oneOfAns.add(root.val);
        ans.add(oneOfAns);
        if(root.left == null && root.right == null) return ans;
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        if(root.left != null) nodes.add(root.left);
        if(root.right != null) nodes.add(root.right);
        zigzagLevelOrderForOneLayer(ans, nodes, fromLeft);
        return ans;
    }

    private void zigzagLevelOrderForOneLayer(List<List<Integer>> ans, Stack<TreeNode> nodes, boolean fromLeft){
        if(nodes.empty()) return;
        Stack<TreeNode> newNodes = new Stack<TreeNode>();
        List<Integer> oneOfAns = new LinkedList<Integer>();
        while (!nodes.empty()){

            TreeNode temp = nodes.peek();
            nodes.pop();

            oneOfAns.add(temp.val);

            if(fromLeft){
                if(temp.left != null) newNodes.add(temp.left);
                if(temp.right != null) newNodes.add(temp.right);
            }else{
                if(temp.right != null) newNodes.add(temp.right);
                if(temp.left != null) newNodes.add(temp.left);
            }

        }
        ans.add(oneOfAns);
        fromLeft = !fromLeft;
        zigzagLevelOrderForOneLayer(ans, newNodes, fromLeft);
        return;
    }



    //剑指 Offer 37. 序列化二叉树
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                res.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        int i = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if(!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }



    //124. 二叉树中的最大路径和
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int leftMaxSum = doesMaxPathSum(root.left);
        int rightMaxSum = doesMaxPathSum(root.right);
        int seftSum = root.val;
        int[] arr = new int[]{seftSum, seftSum + leftMaxSum, seftSum + rightMaxSum, seftSum + leftMaxSum + rightMaxSum};
        int temp = arr[0];
        for(int i = 1; i < 4; i++){
            if(arr[i] > temp) temp = arr[i];
        }
        maxSum = Math.max(maxSum, temp);
        maxPathSum(root.left);
        maxPathSum(root.right);
        return  maxSum;
    }

    private int doesMaxPathSum(TreeNode root){
        if(root == null) return 0;
        int left = doesMaxPathSum(root.left);
        int right = doesMaxPathSum(root.right);
        int res = Math.max(root.val + left, root.val + right);
        res = Math.max(res, root.val);
        return res;
    }





}
