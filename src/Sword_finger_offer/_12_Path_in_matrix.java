package Sword_finger_offer;

public class _12_Path_in_matrix {
    static String word1;
    static char[][] board1;
    static boolean[][] visted;
    static int[][] next=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean exist(char[][] board, String word) {
        word1=word;
        board1=board;
        char first=word.charAt(0);
        int rows= board.length;
        int cols=board[0].length;
        visted=new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j]==first){
                    visted[i][j]=true;
                    if (can(i,j,0)){
                        return true;
                    }
                    visted[i][j]=false;
                }
            }
        }
        return false;

    }
    public static boolean can(int row,int col,int index){
        if (index==word1.length()-1){
            return true;
        }
        boolean b=false;
        for (int[] n : next) {
            int newrow = row + n[0];
            int newcol=col+n[1];
            if (newrow>=0&&newrow< board1.length&&newcol>=0&&newcol<board1[0].length&&!visted[newrow][newcol]&&board1[newrow][newcol]==word1.charAt(index+1)){
                visted[newrow][newcol]=true;
                b=b||can(newrow,newcol,index+1);
                visted[newrow][newcol]=false;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        exist(new char[][]{{'a','b'},{'c','d'}},"abcd");
    }
}
