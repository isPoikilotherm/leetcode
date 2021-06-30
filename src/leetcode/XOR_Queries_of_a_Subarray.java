package leetcode;

public class XOR_Queries_of_a_Subarray {

    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] fontxor=new int[arr.length];
        fontxor[0]=arr[0];
        for (int i = 1; i < arr.length; i++) {
            fontxor[i]=fontxor[i-1]^arr[i];
        }

        int[] ans=new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
                if (queries[i][0]==0){
                    ans[i]=fontxor[queries[i][1]];
                }else {
                    ans[i]=fontxor[queries[i][1]]^fontxor[queries[i][0]-1];
                }
        }
        return ans;

    }
}
