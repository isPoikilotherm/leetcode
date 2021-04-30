

public class Single_Number_II {

    public  static int singleNumber(int[] nums) {
      int[] ansbyte=new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if (((nums[i]>>j)&1)==1){
                    ansbyte[j]+=1;
                }
            }
        }
        int ans=0;
        for (int i = 0; i < 32; i++) {
           if (ansbyte[i]%3==1){
               ans+=1<<i;
           }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(2^1);
        singleNumber(new int[]{0,1,0,1,0,1,99});
    }
}
