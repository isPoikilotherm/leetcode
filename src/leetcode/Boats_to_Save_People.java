package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Boats_to_Save_People {
    public int numRescueBoats(int[] people, int limit) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : people) {
            if (i == limit) {
                ans++;
            } else {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        for (int p : people) {
            if (map.getOrDefault(p,0)!=0){
                int now=p;
                map.put(p, map.get(p) - 1);
                if (map.getOrDefault(limit-now,0)!=0){
                    map.put(limit-now,map.get(limit-now)-1);
                    ans++;
                }else {
                    int i=limit-now-1;
                    int count=1;
                   while (i>0&&now<limit&&count<2){
                       if (limit-now<i){
                           i--;
                           continue;
                       }
                       if (map.getOrDefault(i,0)!=0){
                            now=now+i;
                            map.put(i,map.get(i)-1);
                            count++;
                        }else {
                           i--;
                       }
                    }
                   ans++;
                }
            }
        }
        return ans;

    }
}
