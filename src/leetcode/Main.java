package leetcode;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static int ans;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Stack<Integer> stack=new Stack<>();
        boolean[] tag=new boolean[n+1];
        ans=0;
        stack.add(0);
        dfs(stack,tag,n);
        System.out.println(ans);


    }
    public static void dfs(Stack<Integer> stack,boolean[] tag,int n){
        if (stack.size()== n+1&&stack.peek()==n){
            ans++;
            ans=ans%998244353;
            return;
        }
        for (int i = 1; i < n+1; i++) {
            if (i-stack.peek()<=2&&tag[i]==false){
                stack.add(i);
                tag[i]=true;
                dfs(stack,tag,n);
                tag[i]=false;
                stack.pop();
            }
        }
    }
}