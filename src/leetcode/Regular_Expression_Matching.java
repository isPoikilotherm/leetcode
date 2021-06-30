package leetcode;

public class Regular_Expression_Matching {

    public static boolean isMatch(String s, String p) {
        int sl=s.length();
        int pl=p.length();
        boolean[][]  tag=new boolean[sl+1][pl+1];
        tag[0][0]=true;

        for (int i = 1; i <= pl; i++) {
            if (p.charAt(i-1)=='*'){
                tag[0][i]=tag[0][i-2];
            }
        }

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (s.charAt(i-1)==p.charAt(j-1)){
                    tag[i][j]=tag[i-1][j-1];
                }else {
                    if (p.charAt(j-1)=='.'){
                        tag[i][j]=tag[i-1][j-1];
                    }else {
                        if (p.charAt(j-1)=='*'){
                            if (s.charAt(i-1)==p.charAt(j-2)||p.charAt(j-2)=='.'){
//                                tag[i][j]=tag[i][j-2];//0
//                                tag[i][j]=tag[i][j-1];//1
//                                tag[i][j]=tag[i-1][j];//多个

                                tag[i][j]=tag[i][j-2]||tag[i][j-1]||tag[i-1][j];

                            }else {
                                tag[i][j]=tag[i][j-2];
                            }
                        }
                    }
                }
            }
        }
        return tag[sl][pl];

    }


    public static void main(String[] args) {
        System.out.println(isMatch("aab","c*a*b"));
    }


}
