package leetcode;

public class N_th_Tribonacci_Number {

    public int tribonacci(int n) {
        if (n==0){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        int a=0,b=1,c=1;
        n=n-2;
        while (n>0){
            int next=a+b+c;
            a=b;
            b=c;
            c=next;
            n--;
        }
        return c;

    }
}
