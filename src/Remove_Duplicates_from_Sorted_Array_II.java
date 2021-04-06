public class Remove_Duplicates_from_Sorted_Array_II {

    public int removeDuplicates(int[] nums) {
        int len= nums.length;
        if (len==1){
            return 1;
        }
        int tag=nums[0];
        int count=1;
        int slow=1,fast=1;
        while (fast<len){
            if (nums[fast]==tag){
                count++;
                if (count<3){
                    nums[slow]=nums[fast];
                    slow++;
                    fast++;
                }else {
                    fast++;
                }
            }else {
                tag=nums[fast];
                count=1;
                nums[slow]=nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;

    }
}
