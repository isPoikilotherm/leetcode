package Sword_finger_offer;

public class _13_Range_of_motion_of_robot {
    public int movingCount(int m, int n, int k) {
        boolean[][] canvisit=new boolean[m][n];
        int ans=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0&&j==0){
                    canvisit[0][0]=true;
                    ans++;
                    continue;
                }
                int row=i,col=j,sum=0;
                while (row!=0){
                    sum=sum+(row%10);
                    row=row/10;
                }
                while (col !=0){
                    sum=sum+(col%10);
                    col=col/10;
                }
                if ((sum<=k)&&((i>0&&canvisit[i-1][j])||(j>0&&canvisit[i][j-1]))){
                    canvisit[i][j]=true;
                    ans++;
                }
            }
        }
        return ans;
    }
}
