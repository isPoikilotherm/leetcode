package leetcode;

import java.util.*;

public class Sort_Characters_By_Frequency {

    public String frequencySort(String s) {
        Map<Character,Integer> map=new HashMap<>();
        char[] chars=s.toCharArray();
        for (char ch :
                chars) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch,count+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> queue=new PriorityQueue<>((a,b)->{
           if (b.getValue()!=a.getValue()){
               return b.getValue()-a.getValue();
           }
           return a.getValue()-b.getValue();
        });

        for (Map.Entry<Character,Integer> e :
                map.entrySet()) {
            queue.add(e);
        }
        StringBuilder ans=new StringBuilder();
        while (queue.size()!=0){
            Map.Entry<Character,Integer> e=queue.poll();
            for (int i = 0; i < e.getValue(); i++) {
                ans.append(e.getKey());
            }
        }
        return ans.toString();
    }
}
