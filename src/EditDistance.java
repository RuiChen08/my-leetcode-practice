public class EditDistance {

    public int minDistance(String word1, String word2) {
        int[][] dp =  new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for (int i = 0; i <= word2.length(); i++) dp[0][i] = i;

        for (int r = 1; r <= word1.length(); r++){
            for (int c = 1; c <= word2.length(); c++){

                if (word1.charAt(r-1) == word2.charAt(c-1))
                    dp[r][c] = Math.min(Math.min(dp[r-1][c-1], dp[r-1][c] + 1), dp[r][c-1] + 1);
                else {
                    dp[r][c] = Math.min(Math.min(dp[r-1][c-1], dp[r-1][c]), dp[r][c-1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
