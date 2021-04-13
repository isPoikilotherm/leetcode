import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Minimum_Distance_Between_BST_Nodes {


    public int minDiffInBST(TreeNode root) {

        TreeNode pre=null;
        Stack<TreeNode> stack=new Stack<>();
        int ans=Integer.MAX_VALUE;
        while (root!=null||stack.size()!=0){
            while (root!=null){
                stack.add(root);
                root=root.left;
            }
            TreeNode out=stack.pop();
            if (pre==null){
                pre=out;
            }else {
                ans=Math.min(ans, out.val- pre.val);
                pre=out;
            }
            if (out.right!=null){
                root=out.right;
            }

        }
        return ans;



    }


}
