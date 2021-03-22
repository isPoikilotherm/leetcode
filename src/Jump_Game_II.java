public class Jump_Game_II {

    public static int jump(int[] nums) {
        if (nums.length==1){
            return 0;
        }
        int star=0;
        int end=0;
        int maxlen=0;
        int step=0;
        while (end<nums.length-1){
            while (star<=end){
                maxlen=Math.max(maxlen,star+nums[star]);
                star++;
            }
            end=maxlen;
            step++;
        }

        return step;

    }

    public static void main(String[] args) {
        int temp=jump(new int[]{3,4,3,2,5,4,3});
        System.out.println(temp);
    }
}
