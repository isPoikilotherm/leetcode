package leetcode;


public class Escape_The_Ghosts {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int mlen=Integer.MAX_VALUE;
        for (int i = 0; i < ghosts.length; i++) {
            mlen=Math.min(mlen,Math.abs(ghosts[i][0]-target[0])+Math.abs(ghosts[i][1]-target[1]));
        }
        int need=Math.abs(target[0])+Math.abs(target[1]);
        if (need<mlen){
            return true;
        }
        return false;


    }
}
