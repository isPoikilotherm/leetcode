import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Sliding_Puzzle {

    public int slidingPuzzle(int[][] board) {
        String target="123450";
        int[][] canmove=new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        String begin="";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                begin=begin+board[i][j];
            }
        }
        if (begin.equals(target)){
            return 0;
        }
        int ans=0;
        Queue<String> queue=new LinkedList<>();
        queue.add(begin);
        Set<String> set=new LinkedHashSet<>();
        while (queue.size()!=0){
            int len= queue.size();
            ans++;
            for (int i = 0; i < len; i++) {
                String poll = queue.poll();
                int site=0;
                for (int j = 0; j < poll.length(); j++) {
                    if (poll.charAt(j)=='0'){
                        site=j;
                        break;
                    }
                }
                for (int j = 0; j < canmove[site].length; j++) {
                    char[] temp = poll.toCharArray();
                    char t=temp[canmove[site][j]];
                    temp[canmove[site][j]]='0';
                    temp[site]=t;
                    String s=String.valueOf(temp);
                    if (s.equals(target)){
                        return ans;
                    }
                    if (!set.contains(s)){
                        queue.add(s);
                        set.add(s);
                    }
                }
            }
        }
        return -1;

    }
}
