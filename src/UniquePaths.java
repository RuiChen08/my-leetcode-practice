public class UniquePaths {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++){
            ans[i][0] = i;
        }
        for (int i = 0; i < n; i++){
            ans[0][i] = i;
        }

        for (int r = 1; r < m; r++){
            for (int c = 1; c < n; c++){
                ans[r][c] = ans[r-1][c] + ans[r][c-1];
                System.out.println(ans[r][c]);
            }
        }
        return ans[m-1][n-1];
    }

}
