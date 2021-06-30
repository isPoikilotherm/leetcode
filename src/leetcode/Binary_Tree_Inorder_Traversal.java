package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ans=new ArrayList<>();
        if (root==null){return ans;}
        Stack<TreeNode> stack=new Stack<>();
        while (root!=null||!stack.empty()){
            while (root!=null){
                stack.add(root);
                root=root.left;
            }
            if (!stack.empty()){
                ans.add(stack.peek().val);
                root=stack.pop().right;
            }
        }
        return ans;

    }
}
