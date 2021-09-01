package leetcode;

public class Compare_Version_Numbers {
    public int compareVersion(String version1, String version2) {
        int l1=version1.length();
        int l2=version2.length();
        int v1=0,v2=0;
        while (v1<=l1&&v2<=l2){
            StringBuilder vn1=new StringBuilder();
            while (v1<=l1&&version1.charAt(v1)!='.'){
                vn1.append(version1.charAt(v1));
                v1++;
            }
            v1++;
            StringBuilder vn2=new StringBuilder();
            while (v2<=l2&&version2.charAt(v2)!='.'){
                vn2.append(version1.charAt(v2));
                v2++;
            }
            v2++;
            int iv1=Integer.parseInt(String.valueOf(vn1));
            int iv2=Integer.parseInt(String.valueOf(vn2));
            if (iv1>iv2){
                return 1;
            }
            if (iv1<iv2){
                return -1;
            }
        }
        while (v1<=l1){
            if (version1.charAt(v1)!='0'&&version1.charAt(v1)!='.'){
                return 1;
            }
            v1++;
        }
        while (v2<=l2){
            if (version2.charAt(v2)!='0'&&version2.charAt(v2)!='.'){
                return -1;
            }
            v2++;
        }
        return 0;


    }

//    public static void main(String[] args) {
//        String a="001";
//        System.out.println(Integer.parseInt(a));
//    }

}
