package leetcode;

public class Get_Maximum_in_Generated_Array {
    public int getMaximumGenerated(int n) {
        if (n<2){
            return n;
        }
        int[] nums=new int[n+1];
        nums[0]=0;
        nums[1]=1;
        int ans=1;
        int i=2;
        while (i<=n){
            int font=i/2;;
            if (i%2==0){
                nums[i]=nums[font];
            }else {
                nums[i]=nums[font]+nums[font+1];
            }
            ans=Math.max(ans,nums[i]);
            i++;
        }
        return ans;

    }
}
