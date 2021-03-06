package leetcode;

public class Combination_Sum_IV {

    public int combinationSum4(int[] nums, int target) {
        int len= nums.length;
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < len; j++) {
                if (nums[j]<=i){
                    dp[i]=dp[i]+dp[i-nums[j]];
                }
            }
        }
        return dp[target+1];

    }
}
