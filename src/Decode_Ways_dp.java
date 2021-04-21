

public class Decode_Ways_dp {

    public  static int numDecodings(String s) {
        int len=s.length();
        int[] dp=new int[len+1];
        dp[0]=1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i)!='0'){
                dp[i+1]= dp[i+1]+dp[i];
                if (i>0&&i<len&&s.charAt(i-1)!='0'&&Integer.valueOf(s.substring(i-1,i+1))<=26){
                    dp[i+1]=dp[i+1]+dp[i-1];
                }
            }else {
                if (i>0&&i<len&&s.charAt(i-1)!='0'&&Integer.valueOf(s.substring(i-1,i+1))<=26){
                    dp[i+1]=dp[i+1]+dp[i-1];
                }
            }

        }
        return dp[len];


    }

    public static void main(String[] args) {
        System.out.println(numDecodings("1111111"));
    }




}
