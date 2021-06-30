package leetcode;

public class Capacity_To_Ship_Packages_Within_D_Days {

    public int shipWithinDays(int[] weights, int D) {
        int min=0;
        int max=0;
        for (int i = 0; i < weights.length; i++) {
            min=Math.max(min,weights[i]);
            max=max+weights[i];
        }
        int left=min;
        int right=max+1;
        while (left<right){
            int mid=(left+right)/2;
            if (can(weights,D,mid)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;

    }
    public boolean can(int[] weights, int D,int with){
        int now=0;
        for (int i = 0; i < D; i++) {
            int w=with;
            while (w-weights[now]>=0){
                w=w-weights[now];
                now++;
                if (now== weights.length){
                    return true;
                }
            }
        }
        return false;
    }


}
