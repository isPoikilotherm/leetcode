import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;

public class Ugly_Number_II {
    public static int nthUglyNumber(int n) {
        Set<Long> set=new HashSet<>();
        PriorityQueue<Long> queue=new PriorityQueue<>();
        Long ans = Long.valueOf(1);
        set.add(ans);
        queue.add(ans);
        int[] coun={2,3,5};
        for (int i = 0; i < n; i++) {
            ans=queue.poll();
            for (int j :
                    coun) {
                Long in = ans * j;
                if (!set.contains(in)){
                    set.add(in);
                    queue.add(in);
                }
            }

        }
        return Integer.valueOf(Math.toIntExact(ans));



    }

    public static void main(String[] args) {
        nthUglyNumber(10);
    }
}
