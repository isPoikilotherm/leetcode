package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Postorder_Traversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        if (root==null){ return ans; }

        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre=null;
        while (root!=null||!stack.empty()){
            while (root!=null){
                stack.add(root);
                pre=root;
                root=root.left;
            }
            root=stack.pop();
            if (root.right==null||pre==root.right){
                ans.add(root.val);
                pre=root;
                root=null;
            }else {
                stack.add(root);
                root=root.right;
                pre=root;
            }

        }
        return ans;

    }
}
