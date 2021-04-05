import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

public class Word_Search {

    public static boolean exist(char[][] board, String word) {
        int hegh= board.length;
        int weih=board[0].length;
        if (word.length()>hegh*weih){
            return false;
        }
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < hegh; i++) {
            for (int j = 0; j < weih; j++) {
                if (board[i][j]==word.charAt(0)){
                    list.add(new int[]{i,j});
                }
            }
        }
        if (list.size()==0){
            return false;
        }
        Set<String> set=new LinkedHashSet<>();
        while (list.size()!=0){
            int[] star=list.remove(list.size()-1);
            if (dfs(board,word,set,star,hegh,weih)){
                return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word,Set<String> set,int[] now,int hegh,int weig){
        if (set.size()!=0 && board[now[0]][now[1]]!=word.charAt(set.size())){
            return false;
        }
        if (set.contains(String.valueOf(now[0])+String.valueOf(now[1]))){
            return false;
        }
        if (board[now[0]][now[1]]==word.charAt(set.size())){
            set.add(String.valueOf(now[0])+String.valueOf(now[1]));
        }
        if (set.size()==word.length()){
            return true;
        }
        boolean tag=false;
        if (now[0]-1>=0) {//上
            tag=tag||dfs(board,word,set,new int[]{now[0]-1,now[1]},hegh,weig);
        }
        if (now[0]+1<hegh){
            tag=tag||dfs(board,word,set,new int[]{now[0]+1,now[1]},hegh,weig);
        }
        if (now[1]-1>=0){
            //左
            tag=tag||dfs(board,word,set,new int[]{now[0],now[1]-1},hegh,weig);
        }
        if (now[1]+1<weig){
            //左
            tag=tag||dfs(board,word,set,new int[]{now[0],now[1]+1},hegh,weig);
        }
        set.remove(String.valueOf(now[0])+String.valueOf(now[1]));
        return tag;


    }

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{{'a','a'}},"aa"));
    }
}
