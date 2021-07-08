package Sword_finger_offer;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class _26_Substructures_of_trees {
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B==null){
            return false;
        }
        boolean ans=false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(A);
        while (queue.size()!=0){
            TreeNode node = queue.poll();
            if (node.val==B.val){
                ans=isSub(node.left,B.left)&&isSub(node.right,B.right);
            }
            if (ans){
                return ans;
            }
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }

        return ans;

    }
    public static boolean isSub(TreeNode A, TreeNode B) {
        if (A==null){
            if (B!=null){
                return false;
            }else {
                return true;
            }
        }else {
            if (B==null){
                return true;
            }
        }
        boolean ans=false;
        if (A.val==B.val){
            ans=isSub(A.left,B.left)&&isSub(A.right,B.right);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode B=new TreeNode(4);
        B.left=new TreeNode(1);
        TreeNode A=new TreeNode(3);
        TreeNode A1=new TreeNode(4);
        A1.left=new TreeNode(1);
        A1.right=new TreeNode(2);
        A.left=A1;
        A.right=new TreeNode(5);

        isSubStructure(A,B);
    }
}
