package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Random_Pick_with_Weight {
    int[] list;
    public Random_Pick_with_Weight(int[] w) {
        list=new int[w.length];
        list[0]=w[0];
        for (int i = 1,len= w.length; i < len; i++) {
            list[i]=list[i-1]+ w[i];
        }
    }

    public int pickIndex() {
        int len=list.length;
        int index= new Random().nextInt(list[len-1])+1;
        int low=0,high=list.length-1;
        while (low<high){
            int mid=(high-low)/2+low;
            if (list[mid]<index){
                low=mid+1;
            }else {
                high=mid;
            }
        }
        return low;

    }
}
