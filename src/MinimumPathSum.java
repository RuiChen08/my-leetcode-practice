public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 1; i < m; i++) grid[i][n] += grid[i - 1][n];
        for (int i = 1; i < n; i++) grid[m][i] += grid[m][i - 1];
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                grid[r][c] += Math.min(grid[r - 1][c], grid[r][c - 1]);
            }
        }
        return grid[m - 1][n - 1];
    }

}
