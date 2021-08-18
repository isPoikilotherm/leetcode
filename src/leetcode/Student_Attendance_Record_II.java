package leetcode;

public class Student_Attendance_Record_II {
    public static int checkRecord(int n) {
        long[][][] dp=new long[n+1][3][4];//总长度；A的个数；L的连续个数
        dp[1][1][0]=1;//第一位是A；
        dp[1][0][1]=1;//第一位是L；
        dp[1][0][0]=1;//第一位是P；
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k <3&&k+j<=i; k++) {
                    if (k==0){//只能选A和P
                        if (j==0){//只能选P
                            for (int l = 0; l<3&&l<=i-j; l++) {
                                dp[i][j][k]+=dp[i-1][j][l];
                                dp[i][j][k]=dp[i][j][k]%1000000007;
                            }
                        }else {
                            for (int l = 0; l<3&&l<=i-j; l++) {
                                dp[i][j][k]+=dp[i-1][j][l]+dp[i-1][j-1][l];
                                dp[i][j][k]=dp[i][j][k]%1000000007;
                            }
                        }
                    }else {//只能选L
                        dp[i][j][k]=dp[i-1][j][k-1];
                        dp[i][j][k]=dp[i][j][k]%1000000007;
                    }
                }
            }
        }
        int ans=0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans+=dp[n][i][j];
                ans=ans%1000000007;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println( checkRecord(10101));
    }
}
