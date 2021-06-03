import java.util.HashMap;
import java.util.Map;

public class Contiguous_Array {
    public static int findMaxLength(int[] nums) {
        int len=nums.length;
        if (len==1){
            return 0;
        }
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int[] sum=new int[len];
        if (nums[0]==1){
            sum[0]=1;
            map.put(1,0);
        }else {
            sum[0]=-1;
            map.put(-1,0);
        }
        int maxlen=0;
        for (int i = 1; i < len; i++) {
            if (nums[i]==1){
                sum[i]=sum[i-1]+1;
            }else {
                sum[i]=sum[i-1]-1;
            }
            if (map.containsKey(sum[i])){
                maxlen=Math.max(i-map.get(sum[i]),maxlen);
            }else {
                map.put(sum[i],i);
            }
        }
        return maxlen;

    }

    public static void main(String[] args) {
        findMaxLength(new int[]{0,1,1,0,1,1,1,0});
    }
}
