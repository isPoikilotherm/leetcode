package leetcode;

public class Sum_of_Square_Numbers {


    public boolean judgeSquareSum(int c) {
        double d_c=(double)c;
        double n=Math.sqrt(d_c);
        int count=(int)n;

        for (int i = count,j=0; i >=j ; ) {
            if(i*i+j*j==c){
                return true;
            }
            if(i*i+j*j<c){
                j++;
            }else if(i*i+j*j>c){
                i--;
            }

        }
        return false;
    }


}
