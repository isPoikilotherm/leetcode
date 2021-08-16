package leetcode;

public class Beautiful_Arrangement {
    boolean[] visited;
    int ans=0;
    int N;
    public int countArrangement(int n) {
        visited=new boolean[n];
        N=n;
        dfs(0);
        return ans;

    }
    public void dfs(int len){
        if (len==N){
            ans++;
        }
        for (int i = 1; i <=N; i++) {
            if (!visited[i]){
                if (i%(len+1)==0||(len+1)%i==0){
                    visited[i]=true;
                    len++;
                    dfs(len);
                    len--;
                    visited[i]=false;
                }
            }
        }

    }
}
