import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Brick_Wall {

    public static int leastBricks(List<List<Integer>> wall) {
        int high=wall.size();
        int sum=0;
        for (int i : wall.get(0)) {
            sum+=i;
        }
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < high; i++) {
            int w=0;
            for (int j : wall.get(i)) {
                w+=j;
                if (w!=sum){
                    if (map.containsKey(w)) {
                        map.put(w,map.get(w)+1);
                    }else {
                        map.put(w,1);
                    }
                }
            }
        }

        int ans=0;
        for (int i : map.keySet()) {
            if (map.get(i)>ans){
                ans=map.get(i);
            }
        }
        return high-ans;

    }

    public static void main(String[] args) {
        List<List<Integer>> wall=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(2);
        l1.add(1);
        wall.add(l1);

        List<Integer> l2=new ArrayList<>();
        l2.add(3);
        l2.add(1);
        l2.add(2);
        wall.add(l2);

        List<Integer> l3=new ArrayList<>();
        l3.add(1);
        l3.add(3);
        l3.add(2);
        wall.add(l3);

        List<Integer> l4=new ArrayList<>();

        l4.add(2);
        l4.add(4);
        wall.add(l4);

        List<Integer> l5=new ArrayList<>();
        l5.add(3);
        l5.add(1);
        l5.add(2);
        wall.add(l5);

        List<Integer> l6=new ArrayList<>();
        l6.add(1);
        l6.add(3);
        l6.add(1);
        l6.add(1);
        wall.add(l6);
        leastBricks(wall);
    }
}
