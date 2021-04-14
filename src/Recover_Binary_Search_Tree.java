public class Recover_Binary_Search_Tree {

    TreeNode pre=null;
    TreeNode first=null;
    TreeNode second=null;
    boolean tag=true;
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp= first.val;
        first.val= second.val;
        second.val=temp;

    }

    public void dfs(TreeNode root){
        if(tag==false){
            return;
        }
        if (root==null){
            return;
        }
        dfs(root.left);
        if (pre==null){
            pre=root;
        }else {
            if (pre.val> root.val){
                if (first==null){
                    first=pre;
                    second=root;
                }else {
                    second=root;
                    tag=false;
                }
            }
            pre=root;
        }
        dfs(root.right);
    }
}
