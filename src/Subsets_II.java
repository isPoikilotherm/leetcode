import javax.swing.text.Keymap;
import java.util.*;

public class Subsets_II {
    private static Map<List<Integer>,Integer> map=new HashMap<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> list=new ArrayList<>();
        dfs(nums,list,0);
        List<List<Integer>> res=new ArrayList<>();
        for (Map.Entry<List<Integer>,Integer> an:map.entrySet()){
            res.add(an.getKey());
        }
        return res;


    }

    public  static void dfs(int[] nums,List<Integer> list,int tag){
        if (tag== nums.length){
            List<Integer> list1=new ArrayList<>();
            for (Integer a:list){
                list1.add(a);
            }
            Collections.sort(list1);
            if (!map.containsKey(list1)){

                map.put(list1,1);
            }
            return;
        }
            dfs(nums,list,tag+1);
            list.add(nums[tag]);
            dfs(nums,list,tag+1);
            list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,0}));
    }

}
