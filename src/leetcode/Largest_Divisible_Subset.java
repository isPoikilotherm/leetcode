package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Largest_Divisible_Subset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int len= nums.length;
        List<Integer> ans=new ArrayList<>();
        if (len==1){
            ans.add(nums[0]);
            return ans;
        }
        Arrays.sort(nums);
        int dp[]=new int[len];
        Arrays.fill(dp,1);
        int max=1;
        for (int i = 1; i < len; i++) {
            for (int j = i-1; j>=0 ; j--) {
                if (nums[i]%nums[j]==0){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                    max=Math.max(max,dp[i]);
                }
            }
        }
        for (int i = len-1; i >=0 ; i--) {
            if (ans.size()==0&&dp[i]==max){
                ans.add(0,nums[i]);
                max--;
            }else if (dp[i]==max&&ans.get(0)%nums[i]==0){
                ans.add(0,nums[i]);
                max--;
            }

            if (max==0){
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{4,8,10,240}));
    }

}
