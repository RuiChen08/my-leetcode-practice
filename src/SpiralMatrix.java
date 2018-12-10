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
}
