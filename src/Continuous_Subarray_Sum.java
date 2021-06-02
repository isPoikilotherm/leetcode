import java.util.HashSet;
import java.util.Set;

public class Continuous_Subarray_Sum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int len=nums.length;
        if (len<2){
            return false;
        }
        int[] sums=new int[len];
        sums[0]=nums[0];
        for (int i = 1; i < len; i++) {
            sums[i]=sums[i-1]+nums[i];
        }
        Set<Integer> set=new HashSet<>();
        set.add(0);
        for (int i = 1; i < len; i++) {
            if (set.contains(sums[i]%k)){
                return true;
            }else {
                set.add(sums[i-1]%k);
            }
        }

        return false;

    }

    public static void main(String[] args) {

    }
}
