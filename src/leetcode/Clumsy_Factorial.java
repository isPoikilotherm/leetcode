package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Clumsy_Factorial {

    public static int clumsy(int N) {
        String[] operations=new String[]{"*","/","+","-"};
        Deque<Integer> num=new LinkedList<>();
        Queue<String> oper=new LinkedList<>();
        num.addLast(N);
        for (int i = N-1; i > 0 ; i--) {
           if (operations[(N-i-1)%4].equals("*")){
              int res= num.pollLast()*i;
              num.addLast(res);
           }else if (operations[(N-i-1)%4].equals("/")){
               int res= num.pollLast()/i;
               num.addLast(res);
           }else if (operations[(N-i-1)%4].equals("+")){
               num.addLast(i);
               oper.add("+");
           }else {
               num.addLast(i);
               oper.add("-");
           }
        }
        int ans= num.pollFirst();
        while (num.size()!=0){
            if (oper.peek()=="+"){
                ans=ans+num.pollFirst();
                oper.poll();
            }else {
                ans=ans-num.pollFirst();
                oper.poll();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(clumsy(10));
    }
}
