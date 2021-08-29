package leetcode;

import java.util.*;

public class tttt {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int len=scanner.nextInt();
        int[] nums=new int[len];
        for (int i = 0; i < len; i++) { nums[i]=scanner.nextInt(); }
        Map<Integer, List<int[]>> map=new HashMap<>();
        int count=0,start=0,max=0;
        for (int i = 0; i < len; i++) {
            if (nums[i]==nums[start]){
                count++;
            }else {
                max=Math.max(max,count);
                List<int[]> list = map.getOrDefault(count, new ArrayList<>());
                list.add(new int[]{start,i-1});
                map.put(count,list);
                count=0;
                start=i;
                i--;
            }
        }
        if (count!=0){
            max=Math.max(max,count);
            List<int[]> list = map.getOrDefault(count, new ArrayList<>());
            list.add(new int[]{start,len-1});
            map.put(count,list);
        }
        List<int[]> list = map.get(max);
        boolean tag=false;
        for (int[] nu : list) {
           if (nu[0]>=2){
               if (nums[nu[0]]==nums[nu[0]-2]){
                   tag=true;
               }
           }
           if (nu[1]<=len-3){
               if (nums[nu[1]]==nums[nu[1]+2]){
                   tag=true;
               }
           }
        }
        if (tag){
            System.out.println(max+1);
        }else {
            System.out.println(max);
        }
        return;
    }
}
