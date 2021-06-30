package leetcode;

public class NumArray {
    private int[] presum;
    private int[] nums;

    public NumArray(int[] nums) {
        presum=new int[nums.length+1];
        this.nums=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            this.nums[i]=nums[i];
            presum[i+1]=nums[i]+presum[i];
        }
    }

    public void update(int index, int val) {
        nums[index]=val;
        presum[index+1]=presum[index]+nums[index];
        for (int i = index+2; i < presum.length; i++) {
            presum[i]=presum[i-1]+nums[i-1];
        }

    }

    public int sumRange(int left, int right) {
        return presum[right+1]-presum[left+1]+nums[left];

    }
}
