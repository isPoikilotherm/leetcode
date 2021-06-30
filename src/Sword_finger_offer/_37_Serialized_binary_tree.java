package Sword_finger_offer;


import leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _37_Serialized_binary_tree {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root==null){
            return "";
        }
        StringBuffer stringBuffer=new StringBuffer();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (queue.size()!=0){
            TreeNode node=queue.poll();
            if (node!=null){
               stringBuffer.append(String.valueOf(node.val)+',');
            }else {
                stringBuffer.append("null,");
            }
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        return stringBuffer.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data==""){
            return null;
        }
        String[] strings=data.substring(0,data.length()-1).split(",");
        TreeNode root=new TreeNode(Integer.parseInt(strings[0]));
        TreeNode node=root;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        int site=1;
        while (queue.size()!=0){
            TreeNode node1=queue.poll();
            if (!strings[site].equals("null")){
                node1.left=new TreeNode(Integer.parseInt(strings[site]));
                queue.add( node1.left);
            }
            site++;
            if (!strings[site].equals("null")){
                node1.right=new TreeNode(Integer.parseInt(strings[site]));
                queue.add( node1.right);
            }
            site++;

        }
        return root;

    }

    public static void main(String[] args) {
        deserialize("1,2,3,null,null,4,5,null,null,null,null,");

    }

}
