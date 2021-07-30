package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Path_In_Zigzag_Labelled_Binary_Tree {

    public List<Integer> pathInZigZagTree(int label) {
        int lev=1;
        while (Math.pow(2,(double)lev)-1<label){
            lev++;
        }
        List<Integer> res=new ArrayList<>();
        res.add(label);
       while (lev>1){
           lev--;
           int font= res.get(res.size()-1);
           int cha=(int)(font-Math.pow(2,(double)lev))/2;
           int next=(int) Math.pow(2,(double)lev)-1-cha;
           res.add(next);
       }
        Collections.reverse(res);
       return res;

    }
}
