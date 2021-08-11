package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Arithmetic_Slices_II_Subsequence {
    static int ans=0;
    public static   int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Map<Long, Integer>[] f = new Map[n];
        for (int i = 0; i < n; ++i) {
            f[i] = new HashMap<Long, Integer>();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                long d = 1L * nums[i] - nums[j];
                int cnt = f[j].getOrDefault(d, 0);
                ans += cnt;
                f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        numberOfArithmeticSlices(new int[]{0,2000000000,-294967296});
    }


}
