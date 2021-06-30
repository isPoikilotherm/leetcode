package leetcode;

public class XOR_Operation_in_an_Array {

    public int xorOperation(int n, int start) {
        if (n==1){
            return start;
        }
        int font=(start+2);
        int ans=start^font;

        for (int i = 2; i < n; i++) {
            font=font+2;
            ans=ans^font;
        }
        return ans;


    }
}
