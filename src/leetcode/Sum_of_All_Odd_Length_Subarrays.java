package leetcode;

public class Sum_of_All_Odd_Length_Subarrays {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans=0;
        int len=arr.length;
        for (int i = 1; i < len; i++) {
            arr[i]=arr[i]+arr[i-1];
            if (i%2==0){
                ans+=arr[i];
            }
        }
        ans+=arr[len-1];
        for (int i = 1; i < len-2; i++) {
            for (int j = i+2; j < len; j=j+2) {
                int temp=arr[j]-arr[i-1];
                ans+=temp;
            }
        }
        return ans;


    }

}
