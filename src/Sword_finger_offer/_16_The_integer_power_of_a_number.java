package Sword_finger_offer;

public class _16_The_integer_power_of_a_number {

    public double myPow(double x, int n) {
        if (n==0){
            return 1.0;
        }
        Long N=new Long((long)n);
        return n>0?pows(x,N):1.0/pows(x,0-N);

    }
    public double pows(double x,Long n){
        if (n==1){
            return x;
        }
        double d=pows(x,n/2);

        return n%2==0?d*d:d*d*x;

    }
}
