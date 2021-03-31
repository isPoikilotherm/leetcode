import java.util.*;

public class Longest_Valid_Parentheses {

    public static int longestValidParentheses(String s) {
        int[] num=new int[s.length()];
        Stack<Map<String,Integer>> stack=new Stack<>();
        if (s.length()==0){
            return 0;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('){
                Map<String,Integer> map=new HashMap<>();
                map.put("(",i);
                stack.push(map);
            }else {
                if ((!stack.empty())&&stack.peek().containsKey("(")){
                    Map<String,Integer> lmap=stack.pop();
                    num[i]=1;
                    num[lmap.get("(")]=1;
                }else {
                    Map<String,Integer> map=new HashMap<>();
                    map.put(")",i);
                    stack.push(map);
                }
            }
        }


        int res=0;
        int temp=0;
        for (int i = 0; i < num.length; i++) {
            if (num[i]==0){
                res=Math.max(res,temp);
                temp=0;
            }else {
                temp++;
            }
        }
        res=Math.max(res,temp);
        return res;


    }

    public static void main(String[] args) {
        longestValidParentheses("(()");
    }


}
