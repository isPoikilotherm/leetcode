public class Distinct_Subsequences {
    public int count=0;

    public int numDistinct(String s, String t) {
        if (t.length()>s.length()){
            return 0;
        }
        if (t.length()==0){
            return 1;
        }

        dfs(s,t,0,0);
        return count;

    }

    public void dfs(String s,String t,int s1,int t1){
        if (t1==t.length()){
            count++;
        }
        if (s1==s.length()){
            return;
        }
        for (int i = s1; i < s.length(); i++) {
            if (s.charAt(i)==t.charAt(t1)){
                dfs(s,t,i+1,t1+1);
            }
        }
    }
}
