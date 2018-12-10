import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix{
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> out = new LinkedList<>();
        if (matrix.length == 0) return out;

        int rn = matrix.length, cn = matrix[0].length;

        for (int i = 0; i <  Math.ceil(Math.min(rn, cn) / 2.0); i++) {
            System.out.println("in here");
            performSpiral(matrix, out, i, i, rn - i, cn - i);
        }
        return out;
    }

    public void performSpiral(int[][] matrix, List<Integer> out, int startr, int startc, int endr, int endc){
        int r = startr, c = startc;
        for (; c < endc; c++){
            out.add(matrix[r][c]);
        }
        c--;
        r++;
        for (; r < endr; r++){
            out.add(matrix[r][c]);
        }
        r--;
        c--;
        for (; r != startr && c >= startc; c--){
            out.add(matrix[r][c]);
        }
        c++;
        r--;
        for (;c != endc && r > startr; r--){
            out.add(matrix[r][c]);
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        performSpiral2(matrix, 0, 0, n, 1);
        return matrix;
    }

    public void performSpiral2(int[][] matrix, int startr, int startc, int n, int count){
        int r = startr, c = startc;

        for (; c < startc + n; c++){
            matrix[r][c] = count++;
        }
        c--;
        r++;
        for (; r < startr + n; r++){
            matrix[r][c] = count++;
        }
        r--;
        c--;
        for (; r != startr && c >= startc; c--){
            matrix[r][c] = count++;
        }
        c++;
        r--;
        for (;c != startc + n && r > startr; r--){
            matrix[r][c] = count++;
        }
        if (n > 2) {
            performSpiral2(matrix, r + 1, c + 1, n - 2, count);
        }
    }
}
