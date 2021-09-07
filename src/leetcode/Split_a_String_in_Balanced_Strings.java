package leetcode;

public class Split_a_String_in_Balanced_Strings {
    public int balancedStringSplit(String s) {
        int ans=0, l=0,r=0;
        for(int i=0,len=s.length();i<len;i++){
            if(s.charAt(i)=='L'){
                l++;
            }
            if(s.charAt(i)=='R'){
                r++;
            }
            if (r==l&&r!=0){
                ans++;
                r=0;
                l=0;
            }
        }
      return  ans;
    }
}
