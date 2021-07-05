package Sword_finger_offer;



public class _14_Cut_the_rope {


    public int cuttingRope(int n) {
       if (n<=3){
           return n-1;
       }
       int[] dp=new int[n+1];
       dp[0]=0;
       dp[1]=1;
       dp[2]=2;
       dp[3]=3;

        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <=i/2 ; j++) {
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j] );
            }
        }
        return dp[n];

    }




}
