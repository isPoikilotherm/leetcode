package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> list=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        dfs(1,n,k,list,ans);
        return ans;

    }
    public static void dfs(int star,int n,int k, List<Integer> list,List<List<Integer>> ans){
        if (list.size()==k){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = star; i<n+1 ; i++) {
            list.add(i);
            dfs(i+1,n,k,list,ans);
            list.remove(list.size()-1);
        }


    }

    public static void main(String[] args) {
        System.out.println( combine(4,2));
    }
}
