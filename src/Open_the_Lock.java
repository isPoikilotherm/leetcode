import java.lang.reflect.Array;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Open_the_Lock {

    public static  int openLock(String[] deadends, String target) {
        Queue<String> queue=new LinkedList<>();
        queue.add("0000");
        Set<String> set=new LinkedHashSet<>();
        Set<String> set1=new LinkedHashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }
        int ans=0;
        if (set.contains("0000")){
            return -1;
        }
        if (target.equals("0000")){
            return 0;
        }

        while (queue.size()!=0){
            int len=queue.size();
            ans++;
            for (int i = 0; i < len; i++) {
                String poll = queue.poll();

                for (int j = 0; j < 4; j++) {
                    char[] next=poll.toCharArray();
                    if (next[j]=='9'){
                        next[j]='0';
                    }else {
                        int asc=next[j]-'0'+49;
                        next[j]=(char)asc;
                    }
                    String s1=String.valueOf(next);
                    if (s1.equals(target)){
                        return ans;
                    }
                    if (!set.contains(s1)&&!set1.contains(s1)){
                        queue.add(s1);
                        set1.add(s1);
                    }
                    next=poll.toCharArray();
                    if (next[j]=='0'){
                        next[j]='9';
                    }else {
                        next[j]=(char)(next[j]-'0'+47);
                    }
                    s1=String.valueOf(next);
                    if (s1.equals(target)){
                        return ans;
                    }
                    if (!set.contains(s1)&&!set1.contains(s1)){
                        queue.add(s1);
                        set1.add(s1);
                    }

                }
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[]{"0201","0101","0102","1212","2002"},"0202"));
    }
}
