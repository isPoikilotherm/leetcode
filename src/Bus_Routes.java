import java.util.*;

public class Bus_Routes {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source==target){
            return 0;
        }
        int n=routes.length;
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<Integer> queue=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (Integer station : routes[i]) {
                if (station==source){
                    queue.add(i);
                    set.add(i);
                }
                List<Integer> list = map.getOrDefault(station, new ArrayList<Integer>());
                list.add(i);
                map.put(station,list);
            }
        }
        int ans=0;
        while (queue.size()!=0){
            int len=queue.size();
            ans++;
            for (int i = 0; i < len; i++) {
                Integer poll = queue.poll();
                for (Integer site:routes[poll]) {
                    if (site==target){
                        return ans;
                    }
                    for (Integer bus : map.get(site)) {
                        if (!set.contains(bus)){
                            set.add(bus);
                            queue.add(bus);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
