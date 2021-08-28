package leetcode;

public class Running_Sum_of_1d_Array {
    public int[] runningSum(int[] nums) {
        for (int i = 1,len=nums.length; i < len; i++) {
            nums[i]=nums[i]+nums[i-1];
        }
        return nums;

    }
}
