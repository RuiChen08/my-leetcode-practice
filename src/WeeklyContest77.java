import java.util.*;

public class WeeklyContest77 {

    public int[] numberOfLines(int[] widths, String S) {
        int sum = 0, line = 0;
        for (int i = 0; i < S.length(); i++){
            sum += widths[S.charAt(i) - 'a'];
            if (sum > 100){
                i--;
                line++;
            }
        }
        return new int[] {line + 1, sum};
    }


    String[] maps = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

    public int uniqueMorseRepresentations(String[] words) {
        int count = 0;
        HashSet<String> set = new HashSet<>();
        for (String s : words){
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()){
                sb.append(maps[c - 'a']);
            }
            if (set.add(sb.toString())) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        WeeklyContest77 w = new WeeklyContest77();
        System.out.println(w.splitArraySameAverage(new int[] {3, 1}));
    }

    List<List<Integer>> test = new LinkedList<>();

    public boolean splitArraySameAverage(int[] A) {
        if (A.length == 1) return false;

        int target = 0;
        for (int i : A) target += i;
        target /= A.length;

        Arrays.sort(A);

        return helper(A, target, 0, 0, 0);

    }

    private boolean helper(int[] a, int target, int sum, int index, int len) {
        if (len > a.length / 2) return false;
        if (len != 0 && sum / len >= target) return sum / len >= target;
        return helper(a, target, sum + a[index], index + 1 ,len + 1)
                || helper(a, target, sum, index + 1, len);
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[][] max = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int c = 0; c < grid[0].length; c++) {
                max[i][c] = 100;
            }
        }

        for (int i = 0; i < grid.length; i++){
            int maxLength = 0;
            int maxLength2 = 0;

            for (int c = 0; c < grid[0].length; c++) {
                maxLength = Math.max(maxLength, grid[i][c]);
            }

            for (int c = 0; c < grid[0].length; c++) {
                maxLength2 = Math.max(maxLength2, grid[c][i]);
            }

            for (int c = 0; c < grid[0].length; c++) {
                max[i][c] = Math.min(max[i][c], maxLength);
                max[c][i] = Math.min(max[c][i], maxLength2);
            }
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int c = 0; c < grid[0].length; c++) {
                System.out.print(max[i][c]);
            }
            System.out.println("");
        }
        return sum;
    }
}
