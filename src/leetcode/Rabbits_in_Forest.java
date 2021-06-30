package leetcode;

import java.util.Arrays;

public class Rabbits_in_Forest {

    public int numRabbits(int[] answers) {
        if(answers.length==0){
            return 0;
        }
        if (answers.length==1){
            return answers[0]+1;
        }
        Arrays.sort(answers);
        int tag=answers[0];
        int count=answers[0];
        int ans=answers[0]+1;
        for (int i = 1; i < answers.length; i++) {
            if (tag>0&&answers[i]==count){
                    tag--;
            }else {
                tag=count=answers[i];
                ans+=answers[i]+1;
            }
        }

        return ans;

    }



}
