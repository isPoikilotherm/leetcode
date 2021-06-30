package leetcode;

public class Implement_strStr {

    public static int strStr(String haystack, String needle) {
        if (needle.length()==0){
            return 0;
        }
        if (haystack.length()==0){
            return -1;
        }
        int[] next=getnext(needle);
        int j=0,i=0;
        while (j<haystack.length()){
            if (haystack.charAt(j)==needle.charAt(i)){
                i++;
                j++;
            }else {
               if (i>0){
                   i=next[i-1];
               }else {
                   i=0;
                   j++;
               }
            }
            if (i== needle.length()){
                return j-needle.length();
            }
        }
        return -1;

    }

    public static int[] getnext(String needle){
        int len=needle.length();
        int[] next=new int[len];
        next[0]=0;
       int i=0,j=1;
       while (j<len){
           while (i>0&&needle.charAt(j)!=needle.charAt(i)){
               i=next[i-1];
           }
           if (needle.charAt(j)== needle.charAt(i)){
               next[j]=i+1;
               i++;
               j++;
           }else {
               next[j]=0;
               j++;
           }
       }
       return next;

    }

    public static void main(String[] args) {
        System.out.println(strStr("aaaaa","aabaabaaa"));
    }


}
