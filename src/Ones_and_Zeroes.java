public class Ones_and_Zeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] count=new int[strs.length][2];
        int[][][] dp=new int[strs.length][m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            String s=strs[i];
            int one=0,zero=0;
            for (char c : s.toCharArray()) {
                if (c=='1'){
                    one++;
                }else {
                    zero++;
                }
            }
            count[i][0]=zero;
            count[i][1]=one;
        }
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                dp[0][i][j]=(count[0][0]<=i&&count[0][1]<=j)?1:0;
            }
        }
        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    int nochose=dp[i-1][j][k];
                    int chose=(j >= count[i][0] && k >= count[i][1]) ? dp[i-1][j-count[0][0]][k-count[i][1]] + 1 : 0;
                    dp[i][j][k]=Math.max(nochose,chose);
                }
            }
        }
        return dp[strs.length-1][m][n];

    }
}
