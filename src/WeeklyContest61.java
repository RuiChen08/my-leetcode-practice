import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WeeklyContest61 {


    public int[] dailyTemperatures(int[] T) {
        int[] temp = new int[101];
        int[] news = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--){
            temp[T[i]] = i;

            for (int c = T[i] + 1; c < 101; c++){
                if (temp[c] > 0) {
                    if (news[i] != 0) news[i] = Math.min(temp[c] - i, news[i]);
                    else news[i] = temp[c] - i;
                }
            }
        }
        return news;
    }

    public static void main(String[] args) {
        WeeklyContest61 w = new WeeklyContest61();
        System.out.println(w.deleteAndEarn(new int[] {8,7,3,8,1,4,10,10,10,2}));
    }

    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[10001];
        for (int in : nums) dp[in] += in;

        for (int i = 2; i < 10001; i++){
            dp[i] = Math.max(dp[i-2] + dp[i], dp[i-1]);
        }
        return dp[10000];
    }

    public int monotoneIncreasingDigits(int N) {
        char[] chr = (N+"").toCharArray();
        int lastone = chr.length;
        for (int i = chr.length - 1; i > 0; i--){
            if (chr[i -1] > chr[i]){
                chr[i - 1] -= 1;
                lastone = i;
            }
        }
        for (int i = lastone; i < chr.length; i++)
            chr[i] = '9';
        StringBuilder sb = new StringBuilder();
        for (char c : chr) sb.append(c);
        return Integer.parseInt(sb.toString());
    }

    public int cherryPickup(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int r = 1; r < grid.length; r++){
            if (grid[r][0] == 0) dp[r][0] = dp[r-1][0];
            if (grid[r][0] == 1) dp[r][0] = dp[r-1][0] + 1;
            if (grid[r][0] == -1) dp[r][0] = 0;
        }
        for (int r = 1; r < grid.length; r++){
            if (grid[0][r] == 0) dp[0][r] = dp[0][r-1];
            if (grid[0][r] == 1) dp[0][r] = dp[0][r-1] + 1;
            if (grid[0][r] == -1) dp[0][r] = 0;
        }
        for (int r = 1; r < grid.length; r++){
            for (int c = 1; c < grid[0].length; c++){
                if ( (dp[r-1][c] == 0 && dp[r][c-1] == 0) || grid[r][c] == -1) dp[r][c] = 0;
                else if (grid[r][c] == 0) dp[r][c] = Math.max(dp[r][c-1], dp[r-1][c]);
                else if (grid[r][c] == 1) dp[r][c] = Math.max(dp[r][c-1], dp[r-1][c]) + 1;
            }
        }

        int count = dp[grid.length - 1][grid[0].length - 1];

        if (count == 0) return 0;

        int r = grid.length - 1, c =grid[0].length - 1;
        grid[r][c] = 0;
        while (r != 0 && c != 0){
            if ((dp[r][c] != 0 && dp[r][c-1] > dp[r-1][c])){
                c--;
            } else {
                r--;
            }
            grid[r][c] = 0;
        }

        while (r != 0) {grid[r][c] = 0; r--;}
        while (c != 0) {grid[r][c] = 0; c--;}

        dp = new int[grid.length][grid[0].length];

        dp[0][0] = 0;
        for (r = 1; r < grid.length; r++){
            if (grid[r][0] == 0) dp[r][0] = dp[r-1][0];
            if (grid[r][0] == 1) dp[r][0] = dp[r-1][0] + 1;
            if (grid[r][0] == -1) dp[r][0] = 0;
        }
        for (r = 1; r < grid.length; r++){
            if (grid[0][r] == 0) dp[0][r] = dp[0][r-1];
            if (grid[0][r] == 1) dp[0][r] = dp[0][r-1] + 1;
            if (grid[0][r] == -1) dp[0][r] = 0;
        }
        for (r = 1; r < grid.length; r++){
            for (c = 1; c < grid[0].length; c++){
                if (grid[r][c] == 0) dp[r][c] = Math.max(dp[r][c-1], dp[r-1][c]);
                if (grid[r][c] == 1) dp[r][c] = Math.max(dp[r][c-1], dp[r-1][c]) + 1;
                if (grid[r][c] == -1) dp[r][c] = 0;
            }
        }
        return count + dp[grid.length - 1][grid[0].length - 1];
    }


}
