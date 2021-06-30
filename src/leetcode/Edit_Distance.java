package leetcode;

public class Edit_Distance {

    public static int minDistance(String word1, String word2) {

        int[][] dp=new int[word2.length()+1][word1.length()+1];
        for (int i = 0; i < word1.length()+1; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i < word2.length()+1; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(j-1)==word2.charAt(i-1)){
                        dp[i][j]=dp[i-1][j-1];

                    }else {
                    dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
        }
        return dp[word2.length()][word1.length()];

    }

    public static void main(String[] args) {
        minDistance("","a");
    }
}
