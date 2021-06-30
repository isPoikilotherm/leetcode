package leetcode;

public class Wildcard_Matching {


    public static boolean isMatch(String s, String p) {
        if (p.length()==0){
            if (s.length()==0){
                return true;
            }else {
                return false;
            }
        }

        boolean[][] dp=new boolean[p.length()+1][s.length()+1];
        dp[0][0]=true;
        for (int i = 1; i < p.length()+1; i++) {
            if (p.charAt(i-1)=='*'){
                dp[i][0]=dp[i-1][0];
            }
        }

        for (int j = 1; j < dp[0].length; j++) {//列
            for (int i = 1; i < dp.length; i++) {//行
                if (p.charAt(i-1)==s.charAt(j-1)||p.charAt(i-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    if (p.charAt(i-1)=='*'){
                        dp[i][j]=dp[i-1][j]||dp[i][j-1];
                    }
                }
            }
        }
        return dp[p.length()][s.length()];


    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa","*"));
    }


}
