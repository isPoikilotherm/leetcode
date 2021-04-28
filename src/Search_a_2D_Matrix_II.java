public class Search_a_2D_Matrix_II {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (target<matrix[0][0]){
            return false;
        }
        int m= matrix.length;
        int n=matrix[0].length;
        if (target>matrix[m-1][n-1]){
            return false;
        }
        for (int i = 0,j=n-1; i<m&&j>=0 ;) {
            if (target==matrix[i][j]){
                return true;
            }
            if (target<matrix[i][j]){
                j--;
            } else if (target>matrix[i][j]) {
                i++;
            }
        }
        return false;
    }
}
