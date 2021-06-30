package leetcode;

public class House_Robber_II {
    public  int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        int[][] dp=new int[nums.length][2];
        dp[0][1]=nums[0];
        dp[0][0]=0;
        for (int i = 1; i < nums.length-1; i++) {
            dp[i][1]=dp[i-1][0]+nums[i];
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
        }
        int ans1=Math.max(dp[nums.length-2][0],dp[nums.length-2][1]);
        dp[1][1]=nums[1];
        dp[1][0]=0;
        for (int i = 2; i < nums.length; i++) {
            dp[i][1]=dp[i-1][0]+nums[i];
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
        }
        int ans2=Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
        return Math.max(ans1,ans2);

    }
}
