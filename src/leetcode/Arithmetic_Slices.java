package leetcode;

import java.util.Arrays;
import java.util.Collections;

public class Arithmetic_Slices {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length<3){
            return 0;
        }
        int ans=0;
        for (int i = 0; i <= nums.length-3; i++) {
            int cha=nums[i+1]-nums[i];
            int len=1;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j]-nums[j-1]==cha){
                    len++;
                    if (len>2){
                        ans++;
                    }
                }else {
                    break;
                }
            }
        }
        return ans;
    }
}
