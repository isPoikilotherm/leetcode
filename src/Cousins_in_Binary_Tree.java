import java.util.LinkedList;
import java.util.Queue;

public class Cousins_in_Binary_Tree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if (x== root.val||y== root.val){
            return false;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        boolean existx=false;
        boolean existy=false;
        TreeNode tag=null;
        while (queue.size()!=0){
            int len=queue.size();
            for (int i = 0; i < len; i++) {
                if (queue.peek().left!=null){
                    if (queue.peek().left.val==x){
                        tag=queue.peek();
                        existx=true;
                        if (existy){
                            return true;
                        }
                    }else if (queue.peek().left.val==y){
                        tag=queue.peek();
                        existy=true;
                        if (existx){
                            return true;
                        }
                    }
                    queue.add(queue.peek().left);
                }
                if (queue.peek().right!=null){
                    if (queue.peek().right.val==x){
                        existx=true;
                        if (existy){
                            if (tag== queue.peek()){
                                return false;
                            }
                            return true;
                        }
                    }else if (queue.peek().right.val==y){
                        existy=true;
                        if (existx){
                            if (tag== queue.peek()){
                                return false;
                            }
                            return true;
                        }
                    }
                    queue.add(queue.peek().right);
                }
                queue.poll();

            }
            if (existx||existy){
                return false;
            }
        }
        return true;


    }
}
