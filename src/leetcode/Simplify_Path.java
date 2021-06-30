package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Simplify_Path {

    public String simplifyPath(String path) {
        Deque<String> deque=new LinkedList<>();

        for (int i = 0; i < path.length();) {
            if (path.charAt(i)=='/'){
                i++;
                continue;
            }else if (path.charAt(i)=='.'){
                String s="";
                while (i < path.length()&&path.charAt(i)=='.'){
                   s=s+".";
                    i++;
                }
                if (i==path.length()||path.charAt(i) == '/') {
                    if (s.length()==2){
                        if (deque.size()!=0){
                            deque.pollLast();
                        }
                    }else if (s.length()>=3){
                        deque.addLast(s);
                    }
                }else {
                    //  继续向后遍历
                    while (i < path.length()&&path.charAt(i)!='/'){
                        s=s+path.charAt(i);
                        i++;
                    }
                    deque.addLast(s);
                }
            }else {
                String s="";
                while (i < path.length()&&path.charAt(i)!='/'){
                    s=s+path.charAt(i);
                    i++;
                }
                deque.addLast(s);
            }

        }
        if (deque.size()==0){
            return "/";
        }
        String ans="";
        while (deque.size()!=0){
            ans=ans+"/"+deque.pollFirst();
        }
        return ans;
    }

}
