import java.util.Stack;

public class Number_of_Ways_to_Stay_in_the_Same_Place_After_Some_Steps {

    private static int len;
    private static int[][] tag;
    private static int mod=(int)1e9+7;
    public static int numWays(int steps, int arrLen) {
        tag=new int[steps+1][Math.min((steps/2)+1, arrLen)];
        tag[steps][0]=0;
        tag[steps-1][0]=1;
        tag[steps-1][1]=1;


        for (int i = steps-2; i >=0; i--) {
            for (int j = 0; j < tag[0].length; j++) {
                if (i<j){
                    tag[i][j]=0;
                }
               if (j==0){
                   tag[i][j]=(tag[i+1][j]+tag[i+1][j+1])%mod;
               }else if (j==tag[0].length-1){
                   tag[i][j]=(tag[i+1][j]+tag[i+1][j-1])%mod;
               }else {
                   tag[i][j]=((tag[i+1][j]+tag[i+1][j-1])%mod+tag[i+1][j+1])%mod;
               }
            }
        }
        return tag[0][0];




    }

    public static void main(String[] args) {
        numWays(4,2);
    }








}
