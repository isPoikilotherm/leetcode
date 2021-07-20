package leetcode;

import java.util.Arrays;

public class Minimize_Maximum_Pair_Sum_in_Array {
    public int minPairSum(int[] nums) {
        int len=nums.length;
        Arrays.sort(nums);
        int ans=0;
        for (int i = 0; i < len/2; i++) {
            int j=len-1-i;
            ans=Math.max(ans,nums[i]+nums[j]);
        }
        return ans;


    }
}
