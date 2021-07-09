package leetcode;

public class LCCI_Find_Majority_Element {

    public int majorityElement(int[] nums) {
        int len= nums.length;
        if (len==0){
            return -1;
        }
        int ans=nums[0];
        int count=0;
        for (int i = 0; i < len; i++) {
            if (count==0){
                ans=nums[i];
            }else {
                if (ans==nums[i]){
                    count++;
                }else {
                    count--;
                }
            }
        }
        count=0;
        for (int num : nums) {
            if (num == ans) {
                count++;
            }
        }
        if (count*2>len){
            return ans;
        }else {
            return -1;
        }


    }
}
