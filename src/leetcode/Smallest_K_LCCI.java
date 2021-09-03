package leetcode;

import java.util.PriorityQueue;

public class Smallest_K_LCCI {
    public int[] smallestK(int[] arr, int k) {
        if (k<1){
            return new int[]{};
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for (int i : arr) {
            if (queue.size() < k) {
                queue.add(i);
            }else if (i< queue.peek()){
                queue.poll();
                queue.add(i);
            }
        }
        int[] ans=new int[k];
        for (int i = 0; i < k; i++) {
            ans[i]=queue.poll();
        }
        return ans;
    }
}
