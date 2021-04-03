public class Sort_Colors {

    public void sortColors(int[] nums) {
        int n= nums.length;
        int font=0,mid=0,end=n-1;
        while (mid<=end&&font<end){
            while (font<n&&nums[font]==0){
                font++;
            }
            while (end>=0&&nums[end]==2){
                end--;
            }
            if (nums[mid]==1){
                mid++;
            }else if (nums[mid]==0){
                if (mid>font){
                    int temp=nums[mid];
                    nums[mid]=nums[font];
                    nums[font]=temp;
                }else {
                    mid++;
                }
            }else if (mid<=end){
                int temp=nums[mid];
                nums[mid]=nums[end];
                nums[end]=temp;
            }
        }
    }
}
