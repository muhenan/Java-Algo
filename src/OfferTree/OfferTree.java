package OfferTree;


public class OfferTree {

    //一个数是不是另一个树的子结构
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null) return false;
        if(A == null) return false;
        if(isEuqalTree(A, B)) return true;
        return (isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    private  boolean isEuqalTree(TreeNode A, TreeNode B){
        if(B == null) return true;
        if(A == null) return false;
        if(A.val != B.val) return false;
        return (isEuqalTree(A.left, B.left) && isEuqalTree(A.right, B.right));
    }
}
