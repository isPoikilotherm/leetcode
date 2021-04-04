import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,nums,list,ans);
        return ans;

    }

    public void dfs(int star,int[] nums,List<Integer> list,List<List<Integer>> ans){
        if (star== nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(star+1,nums,list,ans);
        list.add(nums[star]);
        dfs(star+1,nums,list,ans);
        list.remove(list.size()-1);
    }
}
