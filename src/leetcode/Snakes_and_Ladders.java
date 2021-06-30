package leetcode;

import java.util.*;

public class Snakes_and_Ladders {

    public int snakesAndLadders(int[][] board) {
        int rows= board.length;
        int cols=board[0].length;
        Map<Integer,Integer> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        int count=0;
        for (int i = 0; i <rows; i++) {
           int row=rows-1-i;
           if (i%2==0){
               for (int j = 0; j < cols; j++) {
                   count++;
                   if (board[row][j]!=-1){
                       map.put(count,board[row][j]);
                   }
               }
           }else {
               for (int j = cols-1; j >=0 ; j--) {
                   count++;
                   if (board[row][j]!=-1){
                       map.put(count,board[row][j]);
                   }
               }
           }
        }
        int begin=1;
        int ans=0;
        queue.add(begin);
        set.add(begin);
        while (queue.size()!=0){
            int len=queue.size();
            ans++;
            for (int i = 0; i < len; i++) {
                int poll = queue.poll();
                for (int j = 1; j < 7; j++) {
                    if (poll+j>rows*cols){
                        break;
                    }
                    int next=poll+j;
                    if (next==rows*cols){
                        return ans;
                    }

                    if (map.containsKey(next)){
                        if (map.get(next)==rows*cols){
                            return ans;
                        }
                        if (set.contains(map.get(next))){
                            continue;
                        }
                        queue.add(map.get(next));
                        set.add(map.get(next));
                    }else {
                        if (set.contains(next)){
                            continue;
                        }
                        queue.add(next);
                        set.add(next);
                    }
                }
            }
        }
        return -1;
    }
}
