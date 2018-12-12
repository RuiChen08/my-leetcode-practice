public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++){
            ans[i][0] = 1;
        }
        for (int i = 0; i < n; i++){
            ans[0][i] = 1;
        }

        for (int r = 1; r < m; r++){
            for (int c = 1; c < n; c++){
                ans[r][c] = ans[r-1][c] + ans[r][c-1];
            }
        }
        return ans[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] ans = new int[m + 1][n + 1];
        ans[0][1] = 1;

        for (int r = 1; r < m + 1; r++){
            for (int c = 1; c < n + 1; c++){
                ans[r][c] = obstacleGrid[r-1][c-1] == 1 ? 0 : ans[r-1][c] + ans[r][c-1];
            }
        }
        return ans[m][n];
    }

}
