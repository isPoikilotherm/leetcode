package Sword_finger_offer;

public class _4_Search_in_two_dimensional_array {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rows= matrix.length;
        if (rows==0){
            return false;
        }
        int cols= matrix[0].length;
        if (cols==0){
            return false;
        }
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
               int now= matrix[i][j];
               if (now<target){
                   continue;
               }
               if (now==target){
                   return true;
               }
               if (now>target){
                   break;
               }
            }
        }
        return false;
    }
}
