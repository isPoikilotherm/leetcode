package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int tag = 1;//1:向左  2：向下  3：向右  4：向上
        int row = 0, arr = 0;
        int count = m * n;
        for (int i = 0; i < count; ) {
            if (tag == 1) {
                for (int j = 0; j < n; j++) {
                    res.add(matrix[row][arr]);
                    i++;
                    arr++;
                }
                m--;
                arr--;
                row++;
                tag = 2;
            } else if (tag == 2) {
                for (int j = 0; j < m; j++) {
                    res.add(matrix[row][arr]);
                    i++;
                    row++;
                }
                n--;
                row--;
                arr--;
                tag = 3;
            } else if (tag == 3) {
                for (int j = 0; j < n; j++) {
                    res.add(matrix[row][arr]);
                    i++;
                    arr--;
                }
                m--;
                arr++;
                row--;
                tag = 4;
            } else {
                for (int j = 0; j < m; j++) {
                    res.add(matrix[row][arr]);
                    i++;
                    row--;
                }
                n--;
                row++;
                arr++;
                tag = 1;
            }

        }
        return res;


    }

    public static void main(String[] args) {
        int[][] ma = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        spiralOrder(ma);
    }

}
