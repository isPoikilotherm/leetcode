package leetcode;

public class Find_Minimum_in_Rotated_Sorted_Array {

    public int findMin(int[] nums) {
        int len= nums.length;
        if (len==1){
            return nums[0];
        }

       return find(nums,0,len-1);


    }

    public int find(int[] nums,int font,int end){
        if (nums[font]<=nums[end]){
            return nums[font];
        }
        int mid=(font+end)/2;
        return Math.min(find(nums,font,mid),find(nums,mid+1,end));


    }


}
