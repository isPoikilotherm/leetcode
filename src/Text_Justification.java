import java.util.*;

public class Text_Justification {

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans=new ArrayList<>();
        int len= words.length;
        Stack<String> stack=new Stack<>();
        int curlen=0;

        for (int i = 0; i < len;) {
            if (curlen+words[i].length()+stack.size()<=maxWidth){
                stack.add(words[i]);
                curlen=curlen+words[i].length();
                i++;
            }else {
                int spacenum=maxWidth-curlen-stack.size()+1;
                String s="";
                while (stack.size()!=0){
                    if (stack.size()!=1){
                        int num=spacenum/(stack.size()-1);
                        spacenum=spacenum-num;
                        String s1=stack.pop();
                        for (int j = 0; j < num+1; j++) {
                            s1=" "+s1;
                        }
                        s=s1+s;
                    }else {
                        s=stack.pop()+s;
                    }
                }
                int count=maxWidth-s.length();
                for (int j = 0; j < count; j++) {
                    s=s+" ";
                }
                ans.add(s);
                curlen=0;
            }

        }
        String s="";
        while (!stack.empty()){
            if (stack.size()!=1){
                s=" "+stack.pop()+s;
            }else {
                s=stack.pop()+s;
            }
        }
        int count=maxWidth-s.length();
        for (int i = 0; i < count; i++) {
            s=s+" ";
        }
        ans.add(s);

        return ans;

    }

    public static void main(String[] args) {
        fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16);
    }


}
