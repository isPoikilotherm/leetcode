import java.util.*;

public class Unique_Binary_Search_Trees_II {

    public List<TreeNode> generateTrees(int n) {
        if (n==0){
            return new ArrayList<>();
        }
        return dfs(1,n);

    }

    public List<TreeNode> dfs(int font,int end){
        List<TreeNode> list=new ArrayList<>();
        if (font==end){
            TreeNode node=new TreeNode(font);
            list.add(node);
            return list;
        }
        if (font>end){
            list.add(null);
            return list;
        }
        for (int i = font; i <= end; i++) {
            List<TreeNode> left=dfs(font,i-1);
            List<TreeNode> right=dfs(i+1,end);
            for (TreeNode nodel:left) {
                for (TreeNode noder : right) {
                    TreeNode root=new TreeNode(i);
                    root.left=nodel;
                    root.right=noder;
                    list.add(root);
                }
            }
        }
        return list;

    }


}
