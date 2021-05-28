import java.util.Arrays;

public class Total_Hamming_Distance {

    public int totalHammingDistance(int[] nums) {

        int len=nums.length;
        if (len==1||len==0){
            return 0;
        }
        int total=0;

        for (int i = 0; i < 32; i++) {
            int sum0=0,sum1=0;
            for (int j = 0; j < len; j++) {
                int a=nums[j];
                a=a>>i;
                if ((a&1)==1){
                    sum1++;
                }else {
                    sum0++;
                }

            }
            total+=sum0*sum1;
        }
        return total;

    }

//    public int HammingDistance(int a,int b){
//        if (memo[a][b]!=-1){
//            return memo[a][b];
//        }else {
//            int distance=0;
//            while (a!=0||b!=0){
//                if ((a&1)!=(b&1)){
//                    distance++;
//                }
//                a=a>>1;
//                b=b>>1;
//            }
//            memo[a][b]=distance;
//            memo[b][a]=distance;
//            return distance;
//        }
//
//    }
}
