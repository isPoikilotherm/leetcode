package leetcode;

public class Number_of_Submatrices_That_Sum_to_Target {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows=matrix.length;
        int col=matrix[0].length;
        int ans=0;
        int[][] dp=new int[rows][col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = i; k < rows; k++) {
                    for (int l = j; l < col; l++) {
                        if (k==i&&l==j){
                            dp[k][l]=matrix[i][j];
                        }else {
                            if (k==i){
                                dp[k][l]=matrix[k][l]+dp[k][l-1];
                            }else if (l==j){
                                dp[k][l]=matrix[k][l]+dp[k-1][l];
                            }else {
                                dp[k][l]=matrix[k][l]+dp[k-1][l]+dp[k][l-1]-dp[k-1][l-1];
                            }
                        }
                        if (dp[k][l]==target){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
