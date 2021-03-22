import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {

        Stack<Integer>  temp=new Stack<>();

        int sum,a,b;

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")){
                b=temp.pop();
                a=temp.pop();
                sum=a+b;
                temp.push(sum);
            }else if (tokens[i].equals("-")){
                b=temp.pop();
                a=temp.pop();
                sum=a-b;
                temp.push(sum);
            }else if (tokens[i].equals("*")){
                b=temp.pop();
                a=temp.pop();
                sum=a*b;
                temp.push(sum);
            }else if (tokens[i].equals("/")){
                b=temp.pop();
                a=temp.pop();
                sum=a/b;
                temp.push(sum);
            }else {
                temp.push(Integer.valueOf(tokens[i]));
            }
        }
        return temp.pop();


    }
}
