package leetcode;

public class Longest_Palindromic_Substring {

    public  static String longestPalindrome(String s) {

        String res="";
        for (int i = 0; i < s.length(); i++) {
            String s1=get(s,i,i);
            String s2=get(s,i,i+1);
            String maxlens=s1.length()>s2.length()?s1:s2;
            res=maxlens.length()>res.length()?maxlens:res;
        }
        return res;


    }

    public static String get(String s,int left,int right){
        while (left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }


}
