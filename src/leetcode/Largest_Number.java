package leetcode;

public class Largest_Number {

    public String largestNumber(int[] nums) {

        String[] strings=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i]=String.valueOf(nums[i]);
        }
        for (int i = 1; i < strings.length; i++) {
            for (int j = 0; j < strings.length-i; j++) {
                if ((strings[j]+strings[j+1]).compareTo(strings[j+1]+strings[j])>0){
                    String temp=strings[j];
                    strings[j]=strings[j+1];
                    strings[j+1]=temp;
                }

            }
        }
        String ans="";
        for (int i = strings.length-1; i >=0; i--) {
            ans=ans+strings[i];
        }
        if (ans.charAt(0)=='0'){
            return "0";
        }else {
            return ans;
        }


    }
}
