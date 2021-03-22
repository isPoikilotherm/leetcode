import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.min;

public class Minimum_Path_Sum {

    public static int mincount=9999999;

    public static int minCut(String s) {

        int len=s.length();
        if (len==1){
            return 0;
        }
        List<String> list=new  ArrayList<>();

        int res=dfs(s,list,0,len,0);

        return res;


    }
    public static int dfs(String s,List<String> temp,int n,int len,int count){
        if (n==len){
            mincount=count-1<mincount?count-1:mincount;
        }


        for (int i = n; i <len ; i++) {
            String s1 = s.substring(n, i+1);
            boolean tag=true;
            int p=0,q=s1.length()-1;
            char[]  chars=s1.toCharArray();
            while (p<=q){
                if (chars[p]!=chars[q]){
                    tag=false;
                }
                p++;
                q--;
            }
            if (tag==false){
                continue;
            }
            temp.add(s1);
            count++;
            dfs(s,temp,i+1,len,count);
            count--;
            temp.remove(temp.size()-1);

        }
        return mincount;

    }

    public static void main(String[] args) {
        int a=minCut("cdd");
        System.out.println(a);



    }



}
