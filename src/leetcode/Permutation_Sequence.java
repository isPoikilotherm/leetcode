package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutation_Sequence {

    private String ans="";
    private int count;
    public String getPermutation(int n, int k) {
        int[] tag=new int[n];
        int count=0;
        dfs(tag,n,k,new ArrayList<>());
        return ans;
    }

    public void dfs(int[] tag, int n,int k, List<Integer> list){
        if (list.size()==n){
            count++;
            return;
        }
        if (count==k){
            for (Integer i:list
                 ) {
                ans=ans+Integer.toString(i);
            }
        }


        for (int i = 1; i < n+1; i++) {
            if (tag[i-1]==1){
                continue;
            }

            list.add(i);
            tag[i-1]=1;
            dfs(tag,n,k,list);
            tag[i-1]=0;
            list.remove(list.size()-1);
            if (ans.length()==n){
                return;
            }

        }
    }
}
