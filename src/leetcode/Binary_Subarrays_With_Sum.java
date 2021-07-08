package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Binary_Subarrays_With_Sum {
    public int numSubarraysWithSum(int[] nums, int goal) {

        int len=nums.length;
        int[] sum=new int[len+1];
        for (int i = 0; i < len; i++) {
            sum[i+1]=sum[i]+nums[i];
        }
        if (goal>sum[len]){
            return 0;
        }
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i = 1; i <=len; i++) {
            int find=sum[i]-goal;
            ans+=map.getOrDefault(find,0);
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return ans;
    }
}
