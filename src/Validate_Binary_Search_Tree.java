public class Validate_Binary_Search_Tree {

    public TreeNode pre=null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)){
            return false;
        }
        if (pre==null){
            pre=root;
        }else {
            if (pre.val>= root.val){
                return false;
            }
            pre=root;
        }
        return isValidBST(root.right);



    }

}
