package leetcode;

public class Palindromic_Substrings {

    public int countSubstrings(String s) {
        int ans=0;
        for (int i = 0; i < s.length(); i++) {
            int a1=get(s,i,i);
            int a2=get(s,i,i+1);
            ans=ans+a1+a2;
        }
        return ans;

    }

    public int get(String s,int left,int right){
        int ans=0;
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
            ans++;
        }
        return ans;
    }
}
