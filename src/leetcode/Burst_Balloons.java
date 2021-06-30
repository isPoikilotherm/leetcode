package leetcode;

public class Burst_Balloons {

    public int maxCoins(int[] nums) {
        int len=nums.length;
        int[] newnums=new int[len+2];
        newnums[0]=newnums[newnums.length-1]=1;
        for (int i = 0; i < len; i++) {
            newnums[i+1]=nums[i];
        }
        int[][] dp=new int[len+2][len+2];

        for (int i = 2; i < len+2; i++) {//长度
            for (int j = 0; j < len+2-i ; j++) {
                for (int k = j+1; k < j+i; k++) {
                    dp[j][j+i]=Math.max(dp[j][j+i],dp[j][k]+dp[k][j+i]+newnums[j]*newnums[k]*newnums[j+i]);
                }

            }

        }

        return dp[0][len+1];


    }


}
