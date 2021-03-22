import java.util.ArrayList;
import java.util.List;

public class Basic_Calculator {

    public static int calculate(String s) {
        if (s.length()==1){
            return Integer.valueOf(s);
        }
        List<String> stack=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                continue;
            }
            if (s.charAt(i)=='('||s.charAt(i)=='+'||s.charAt(i)=='-'){
                if (s.charAt(i)=='-'&&stack.size()==0){
                    stack.add("0");
                }
                stack.add(String.valueOf(s.charAt(i)));
            }else {
               if (s.charAt(i)!=')'){
                   String s1=String.valueOf(s.charAt(i));
                   while (i<s.length()-1&&s.charAt(i+1)!='('&&s.charAt(i+1)!=')'&&s.charAt(i+1)!='+'&&s.charAt(i+1)!='-'&&s.charAt(i+1)!=' '){
                       i++;
                       s1=s1+String.valueOf(s.charAt(i));
                   }
                   stack.add(s1);
               }else {
                   List<String> mid=new ArrayList<>();
                   while (stack.size()>0 && !stack.get(stack.size()-1).equals("(")){
                       mid.add(0,stack.remove(stack.size()-1));
                   }
                   if (stack.size()!=0){
                       stack.remove(stack.size()-1);
                   }
                   int first=Integer.valueOf(mid.remove(0));

                   while (mid.size()!=0){
                       String fh=mid.remove(0);
                       int  second=Integer.valueOf(mid.remove(0));
                       if (fh.equals("+")){
                           first=first+second;
                       }else {
                           first=first-second;
                       }
                   }
                   if (first<0&&stack.size()!=0){
                       if (stack.get(stack.size()-1).equals("-")){
                           stack.remove(stack.size()-1);
                           stack.add("+");
                       }else {
                           stack.remove(stack.size()-1);
                           stack.add("-");
                       }
                       first=0-first;
                   }
                   stack.add(String.valueOf(first));
               }
            }
        }
        int sum=Integer.valueOf(stack.remove(0));
        while (stack.size()!=0){
           String fh=stack.remove(0);
           int second=Integer.valueOf(stack.remove(0));
            if (fh.equals("+")){
                sum=sum+second;
            }else {
                sum=sum-second;
            }
        }
        return sum;





    }


    public static void main(String[] args) {
      int res= calculate("(5-6)");
        System.out.println(res);
    }
}
