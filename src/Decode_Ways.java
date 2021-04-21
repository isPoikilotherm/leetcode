import java.util.HashMap;
import java.util.Map;

public class Decode_Ways {

    private static Map<Integer,Integer> map=new HashMap<>();
    public  static int numDecodings(String s) {
        int ans=0;
        ans=dfs(s,0);

        return ans;

    }

    public static int dfs(String s,int index){
        if (map.containsKey(index)){
            return map.get(index);
        }
        if (index>=s.length()){
            return 1;
        }
        int select_one=0;
        int select_two=0;
        if (s.charAt(index)!='0'){
            if (index<s.length()-1&&s.charAt(index+1)=='0'){
                if (Integer.valueOf(s.substring(index,index+2))<=26){
                    select_two=dfs(s,index+2);
                }
            }else {
                select_one=dfs(s,index+1);
                if (index<s.length()-1&&Integer.valueOf(s.substring(index,index+2))<=26){
                        select_two= dfs(s,index+2);
                }

            }
        }
        map.put(index,select_one+select_two);
        return select_one+select_two;

    }

    public static void main(String[] args) {
        System.out.println(numDecodings("11111111111"));
    }
}
