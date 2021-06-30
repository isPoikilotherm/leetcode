package leetcode;

import java.util.Deque;
import java.util.Stack;

public class _132_Pattern {

    public static boolean find132pattern(int[] nums) {
        int[] minleft=new int[nums.length];
        //int[] maxright=new int[nums.length];
        Stack<Integer> stack=new Stack();
        int second=nums[nums.length-1];

        minleft[0]=nums[0];
        for (int i = 1; i < nums.length-1; i++) {
            minleft[i]=Math.min(nums[i-1],minleft[i-1]);
        }

        for (int i = nums.length-1; i >0; i--) {
            if (stack.empty()){
                stack.push(nums[i]);
            }else {
                while (!stack.empty()&&stack.peek()<nums[i]){
                   second=stack.pop();
                }
                stack.push(nums[i]);

                if (second>minleft[i]&&second<nums[i]){
                    return true;
                }
            }

        }
        return false;




    }

    public static void main(String[] args) {
        System.out.println(find132pattern(new int[]{3,1,4,2}));
    }



}
