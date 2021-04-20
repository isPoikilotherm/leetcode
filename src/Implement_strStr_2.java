public class Implement_strStr_2 {

    public static int strStr(String haystack, String needle) {
        if (needle.length()==0){
            return 0;
        }
        if (haystack.length()==0){
            return -1;
        }

        String s="";
        int l1=haystack.length();
        int l2=needle.length();
        for (int i = 0; i <=l1-l2; i++) {
            s=haystack.substring(i,i+l2);
            if (s.equals(needle)){
                return i;
            }
        }
        return -1;


    }




}
