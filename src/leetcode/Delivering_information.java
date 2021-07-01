package leetcode;

import java.util.*;

public class Delivering_information {
    public static int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for (int[] ints : relation) {
            Set<Integer> set;
            set = map.getOrDefault(ints[0], new HashSet<>());
            set.add(ints[1]);
            map.put(ints[0], set);
        }
        Queue<Integer> queue=new LinkedList<>();
        int trail=0;
        int ans=0;
        queue.add(0);
        while (queue.size()>0&&trail<k){
            int len=queue.size();
            trail++;
            for (int i = 0; i < len; i++) {
                Integer poll = queue.poll();
                if (!map.containsKey(poll)){
                    continue;
                }
                Set<Integer> set1=map.get(poll);
                for (int next :
                        set1) {
                    if (trail==k){
                        if (next==n-1){
                            ans++;
                        }
                    }else {
                        queue.add(next);
                    }

                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        numWays(3,new int[][]{{0,1},{0,2},{2,1},{1,2},{1,0},{2,0}},5);
    }
}
