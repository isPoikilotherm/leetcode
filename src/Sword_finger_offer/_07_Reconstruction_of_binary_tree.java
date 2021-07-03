package Sword_finger_offer;
import leetcode.TreeNode;


public class _07_Reconstruction_of_binary_tree {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length==0){return null;}

        TreeNode treeNode=new TreeNode(preorder[0]);
        int begin1=0;
        while (preorder[0]!= inorder[begin1]){
            begin1++;
        }
        treeNode.left=buildRoot(preorder,1,begin1,inorder,0,begin1-1);
        treeNode.right=buildRoot(preorder,begin1+1, preorder.length-1, inorder,begin1+1,inorder.length-1);
        return treeNode;


    }

    public static TreeNode buildRoot(int[] preorder,int begin,int end,int[] inorder,int inbegin,int inend){
        if (begin>end&&inbegin>inend){
            return null;
        }
        TreeNode treeNode=new TreeNode(preorder[begin]);
        int begin1=inbegin;
        while (preorder[begin]!= inorder[begin1]){
            begin1++;
        }
        int count=begin1-inbegin;


        treeNode.left=buildRoot(preorder,begin+1,begin+count,inorder,inbegin,begin1-1);
        treeNode.right=buildRoot(preorder,begin+count+1,end,inorder,begin1+1,inend);
        return treeNode;
    }

    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}
