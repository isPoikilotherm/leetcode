import java.util.Comparator;
import java.util.PriorityQueue;

public class Find_Kth_Largest_XOR_Coordinate_Value {
    public static int kthLargestValue(int[][] matrix, int k) {

        int weig=matrix[0].length;
        int heig= matrix.length;
        int[][] xor=new int[heig][weig];
        PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        xor[0][0]=matrix[0][0];
        queue.add(matrix[0][0]);
        for (int i = 1; i < weig; i++) {
            xor[0][i]=xor[0][i-1]^matrix[0][i];
            queue.add(xor[0][i]);
        }
        for (int i = 1; i < heig; i++) {
            xor[i][0]=xor[i-1][0]^ matrix[i][0];
            queue.add(xor[i][0]);
        }
        for (int i = 1; i < heig; i++) {
            for (int j = 1; j < weig; j++) {
                xor[i][j]=xor[i-1][j]^xor[i][j-1]^xor[i-1][j-1]^matrix[i][j];
                queue.add(xor[i][j]);
            }
        }
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[][] can={{5,2},{1,6}};
        kthLargestValue(can,1);
    }
}
