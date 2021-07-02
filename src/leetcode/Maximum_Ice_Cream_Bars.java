package leetcode;

import java.util.Arrays;

public class Maximum_Ice_Cream_Bars {
    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);
        if (costs[0]>coins){
            return 0;
        }
        int ans=0;
        while (coins>0&&ans<costs.length){
            coins=coins-costs[ans];
            ans++;
        }
       if (coins<0){
           return ans-1;
       }else {
           return ans;
       }

    }
}
