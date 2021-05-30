public class Power_of_Two {

    public boolean isPowerOfTwo(int n) {
        if (n<1){
            return false;
        }
        if (n==1){
            return true;
        }
        int count=0;
        for (int i = 0; i < 32; i++) {
            if ((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        if (count==1){
            return true;
        }else {
            return false;
        }

    }
}
