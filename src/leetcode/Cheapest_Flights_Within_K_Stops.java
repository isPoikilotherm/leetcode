package leetcode;

import java.util.*;

public class Cheapest_Flights_Within_K_Stops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map=new HashMap<>();
        for (int[] i : flights) {
            List<int[]> list=map.getOrDefault(i[0],new ArrayList<>());
            list.add(new int[]{i[1],i[2]});
            map.put(i[0],list);
        }
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{src,0});
        int[] price=new int[n];
        Arrays.fill(price,Integer.MAX_VALUE);
        int sit=0;
        int ans=Integer.MAX_VALUE;
        while (queue.size()!=0&&sit<=k){
            for (int i = 0, len= queue.size(); i < len; i++) {
                int[] font=queue.poll();
                List<int[]> lists=map.getOrDefault(font[0],new ArrayList<>());
                if (lists.size()!=0){
                    for (int[] list :lists ){
                        int[] next=new int[2];
                        next[0]=list[0];
                        next[1]=font[1]+list[1];
                        if (next[0]==dst){
                            ans=Math.min(ans,next[1]);
                        }else {
                            if (next[1]<price[next[0]]){
                                queue.add(next);
                                price[next[0]]=next[1];
                            }
                        }
                    }
                }
            }
            sit++;
        }
        if (ans==Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
    public static void main(String[] args) {
        findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,1);
    }
}
