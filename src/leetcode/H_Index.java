package leetcode;

import java.util.Arrays;

public class H_Index {
    public int hIndex(int[] citations) {
        int len= citations.length;
        if (len==0){
            return len;
        }
        Arrays.sort(citations);
        int i= citations.length-1;
        int j=0;
        while (i>=0){
            if (citations[i]>=j+1){
                i--;
                j++;
                continue;
            }else {
               break;
            }
        }
        return j;
    }
}
