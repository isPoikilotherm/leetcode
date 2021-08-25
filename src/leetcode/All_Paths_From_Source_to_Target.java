package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class All_Paths_From_Source_to_Target {

    List<List<Integer>> ans;
    Map<Integer,int[]> map;
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans=new ArrayList<>();
        map=new HashMap<>();
        n= graph.length;
        for (int i = 0,len= graph.length; i < len; i++) {
            map.put(i, graph[i]);
        }
        List<Integer> list=new ArrayList<>();
        list.add(0);
        dfs(0,list);
        return ans;
    }
    public void dfs(int nowsite,List<Integer> nowlist){
        if (nowsite==n-1){
            List<Integer> list=new ArrayList<>(nowlist);
            ans.add(list);
            return;
        }
        for (int i : map.get(nowsite)) {
            nowlist.add(i);
            dfs(i,nowlist);
            nowlist.remove(nowlist.size()-1);
        }
    }

}
