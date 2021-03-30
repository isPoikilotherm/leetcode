public class Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m= matrix.length;
        int n=matrix[0].length;
        if (target< matrix[0][0]||target>matrix[m-1][n-1]){
            return false;
        }
        int i=0;
        while (i<m&&target>=matrix[i][0]){
            i++;
        }
        i--;
        if (target>matrix[i][n-1]){
            return false;
        }
        for (int j = 0; j < n; j++) {
            if (target==matrix[i][j]){
                return true;
            }
        }
        return false;

    }
}
