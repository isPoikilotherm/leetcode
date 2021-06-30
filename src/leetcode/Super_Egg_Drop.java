package leetcode;

public class Super_Egg_Drop {

    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];//行是鸡蛋数，列是楼层数
        for (int i = 0; i < n + 1; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }
        for (int i = 0; i < k + 1; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }
        for (int i = 2; i < k + 1; i++) {//鸡蛋
            for (int j = 2; j < n + 1; j++) {//楼层
                int font = 1;
                int end = j;
                while (font + 1 < end) {
                    int mid = (font + end) / 2;
                    int x1 = dp[i - 1][mid - 1];
                    int x2 = dp[i][j - mid];
                    if (x1 > x2) {
                        font = mid;
                    } else if (x1 < x2) {
                        end = mid;
                    } else {
                        font = end = mid;
                    }
                }
                dp[i][j] = Math.min(Math.max(dp[i - 1][font - 1], dp[i][j - font]), Math.max(dp[i - 1][end - 1], dp[i][j - end])) + 1;
            }
        }

        return dp[k][n];


    }

    public static void main(String[] args) {
        System.out.println(superEggDrop(2, 6));
    }
}
