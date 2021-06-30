package leetcode;

public class Trapping_Rain_Water {
    public int trap(int[] height) {
        if (height.length<3){
            return 0;
        }
        int[] leftmax=new int[height.length];
        int[] rightmax=new int[height.length];
        leftmax[0]=-1;
        for (int i = 1; i < leftmax.length; i++) {
            leftmax[i]=Math.max(leftmax[i-1],height[i-1]);
        }
        rightmax[rightmax.length-1]=-1;
        for (int i = rightmax.length-2; i>=0 ; i--) {
            rightmax[i]=Math.max(rightmax[i+1],height[i+1]);
        }
        int ans=0;
        for (int i = 1; i < height.length-1; i++) {
            int min=Math.min(leftmax[i],rightmax[i]);
            if (min>height[i]){
                ans=ans+min-height[i];
            }
        }
        return ans;


    }

}
