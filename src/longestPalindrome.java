import java.util.Arrays;

public class longestPalindrome {

    public static void main(String[] args) {
        longestPalindrome longestPalindrome = new longestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("abccd"));
        System.out.println(longestPalindrome.longestPalindrome(""));
    }

    // This algorithm has a O(n^2) space complexity
//    public String longestPalindrome(String s) {
//        if (s.length() == 0) return "";
//        boolean[][] record = new boolean[s.length()][s.length()];
//        record[0][0] = true;
//        // Initial value of DP
//        for (int i = 1; i < s.length(); i++) {
//            record[i][i] = true;
//            record[i-1][i] = s.charAt(i - 1) == s.charAt(i);
//        }
//
//        // Get palindrome from previous palindrome
//        for (int j = 2; j < s.length(); j++){
//            for (int i = j - 2; i >= 0; i--){
//                record[i][j] = record[i+1][j-1] & s.charAt(i) == s.charAt(j);
//            }
//        }
//
//        int x = 0, y = 0;
//        for (int i = 0; i < s.length(); i++){
//            for (int j = i; j < s.length(); j++){
//                if (record[i][j] && j - i > y - x){
//                    x = i;
//                    y = j;
//                }
//            }
//        }
//
//        return s.substring(x, y + 1);
//    }

    public String longestPalindrome(String s) {
        int temp, start = 0, end = 0, max_length = 0;
        for (int i = 0; i < s.length(); i++){
            temp = checkPalindrome(s, i, i);
            if (2 * temp + 1 > max_length){
                max_length = 2 * temp + 1;
                start = i - temp;
                end = i + temp + 1;
            }

            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)){
                temp = checkPalindrome(s, i, i + 1);
                if (2 * temp + 2 > max_length){
                    max_length = 2 * temp + 2;
                    start = i - temp;
                    end = i + temp + 2;
                }
            }
        }
        return s.substring(start, end);
    }

    private int checkPalindrome(String s, int start, int end) {
        int length = 0;
        while (--start >= 0 && ++end < s.length() && s.charAt(start) == s.charAt(end)) length++;
        return length;
    }
}
