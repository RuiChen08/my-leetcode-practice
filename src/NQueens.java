import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new LinkedList<>();

        solveNQueensHelper(ans, n, 0, new int[n]);

        return ans;
    }

    public static void main(String[] args) {
        NQueens n = new NQueens();
        System.out.println(n.totalNQueens(10));
    }

    public int totalNQueens(int n) {
        return solveNQueensHelper(n, 0, new int[n]);
    }

    private int solveNQueensHelper(int n, int i, int[] place) {
        int count = 0;
        if (i == n) {
            return 1;
        }
        else {
            for (int c = 1; c <= n; c++) {
                place[i] = c;
                if (allowed(place, c, i)) count += solveNQueensHelper(n, i + 1, place);
                place[i] = 0;
            }
        }
        return count;
    }

    private void solveNQueensHelper(List<List<String>> ans, int n, int i, int[] place) {
        if (i == n) {
            generatePlacement(ans, place);
        }
        else {
            for (int c = 1; c <= n; c++) {
                place[i] = c;
                if (allowed(place, c, i)) solveNQueensHelper(ans, n, i + 1, place);
                place[i] = 0;
            }
        }
    }

    private void generatePlacement(List<List<String>> ans, int[] place) {
        List<String> aaa = new LinkedList<>();
        for (int i = 0; i < place.length; i++){
            aaa.add(getString(place[i] - 1, place.length));
        }
        ans.add(aaa);
    }

    private boolean allowed(int[] place, int c, int i) {
        for (int w = 0; w < i; w++){
            if (place[w] == place[i] || Math.abs(place[w] - place[i]) == i - w) return false;
        }
        return true;
    }

    private String getString(int i, int n) {
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < n; c++){
            if (c != i) sb.append('.');
            else sb.append('Q');
        }
        return sb.toString();
    }
}
