package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Count_Good_Meals {

    public int countPairs(int[] deliciousness) {

        Map<Integer,Integer> map=new HashMap<>();
        int maxde=0;
        for (int i : deliciousness) {
            maxde=Math.max(maxde,i);
        }
        int maxsum=maxde*2;
        int ans=0;
        for (int i : deliciousness) {
            for (int j = 1; j <= maxsum; j=j<<1) {
                int count=map.getOrDefault(j-i,0);
                ans+=count;
                ans=ans%1000000007;
            }
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return ans;


    }

}
