package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if (root==null){
            return ans;
        }
        Deque<TreeNode> deque=new LinkedList<>();

        deque.add(root);
        while (deque.size()!=0){
            int len=deque.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node=deque.poll();
                list.add(node.val);
                if (node.left!=null){
                    deque.addLast(node.left);
                }
                if (node.right!=null){
                    deque.addLast(node.right);
                }
            }
            ans.add(list);
        }
        return ans;


    }
}
