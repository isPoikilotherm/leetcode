import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Delete_and_Earn {

    public int deleteAndEarn(int[] nums) {
        int len= nums.length;
        Arrays.sort(nums);
        int star=nums[0];
        Map<Integer,Integer> map=new HashMap<>();
        map.put(nums[0],1);
        for (int i = 1; i < len; i++) {
            if (nums[i]==star){
                map.put(star,map.get(star)+1);
            }else {
                star=nums[i];
                map.put(star,1);
            }
        }
        int max=nums[len-1];
        int[][] dp=new int[max+1][2];
        dp[0][1]=0;
        dp[0][0]=0;
        int ans=0;
        for (int i = nums[0]; i <= max; i++) {
            if (map.containsKey(i)){
                dp[i][1]=dp[i-1][0]+(i*map.get(i));
            }else {
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]);
            }
            dp[i][0]=Math.max(dp[i-1][1],dp[i-1][0]);
            ans=Math.max(ans,Math.max(dp[i][1],dp[i][0]));
        }
        return ans;

    }
}
