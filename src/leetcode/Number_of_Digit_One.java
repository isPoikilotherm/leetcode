package leetcode;

public class Number_of_Digit_One {
    public int countDigitOne(int n) {
        int ans=0;
        int font=n/10;
        int end=0;
        int now=n%10;
        int dig=1;
        while (font!=0||now!=0){
            int count;
            if (now==0){
                count=font*dig;
            }else if (now==1){
                count=font*dig+end+1;
            }else {
                count=(font+1)*dig;
            }
            ans+=count;
            end+=now*dig;
            now=font%10;
            font=font/10;
            dig=dig*10;
        }
        return ans;

    }
}
