package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Set_Mismatch {

    public int[] findErrorNums(int[] nums) {
        int len= nums.length;
        int[] ans=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i :
                nums) {
            int value = map.getOrDefault(i, 0);
            map.put(i,value+1);
        }
        for (int i = 1; i <= len; i++) {
            int value=map.getOrDefault(i,0);
            if (value==2){
                ans[0]=i;
            }
            if (value==1){
                ans[1]=i;
            }
        }

        return ans;




    }
}
