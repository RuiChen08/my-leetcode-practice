import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeeklyContest74 {

    public boolean validTicTacToe(String[] board) {
        int XCount = 0, OCount = 0;
        boolean XWin = Win(board, 'X'), OWin = Win(board, 'O');
        for (String s : board){
            for (int i = 0; i < 3; i++){
                if (s.charAt(i) == 'O') OCount++;
                if (s.charAt(i) == 'X') XCount++;
            }
        }
        if (XWin && OWin) return false;
        else if (XWin) return XCount == OCount + 1;
        else if (OWin) return XCount == OCount;
        return XCount == OCount + 1 || XCount == OCount;
    }

    public boolean Win(String[] board, Character cha){
        for (int i = 0; i < 3; i++){
            if (board[i].charAt(0) == cha && board[i].charAt(1) == cha && board[i].charAt(2) == cha) return true;
            else if (board[0].charAt(i) == cha && board[1].charAt(i) == cha && board[2].charAt(i) == cha) return true;
        }
        if (board[0].charAt(0) == cha && board[1].charAt(1) == cha && board[2].charAt(2) == cha) return true;
        else if (board[2].charAt(0) == cha && board[1].charAt(1) == cha && board[0].charAt(2) == cha) return true;
        return false;
    }

    public int numMatchingSubseq(String S, String[] words) {
        Arrays.sort(words);
        Map<String, Integer> maps = new HashMap<>();
        int count = 0;
        for (int i = 0; i < words.length; i++){
            String s = words[i];
            if (maps.containsKey(s)) count += maps.get(s);
            else {
                if (isSubsequence(S, s)) {
                    count++;
                    maps.put(s, 1);
                } else {
                    maps.put(s, 0);
                }
            }
        }
        return count;
    }

    public boolean isSubsequence(String s1, String s2){
        int cursor = 0;
        for (int i = 0; i < s1.length(); i++){
            if (cursor == s2.length()) return true;
            if (s1.charAt(i) == s2.charAt(cursor)) cursor++;
        }
        return cursor == s2.length();
    }

    public static void main(String[] args) {
        WeeklyContest74 w = new WeeklyContest74();
        System.out.println(w.numSubarrayBoundedMax(new int[] {409,96,729}, 542, 772));
    }

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int count = 0, prev = 0, tempCount = 0;

        for (int i = 0; i < A.length; i++){
            if (A[i] < L) tempCount++;
            else {
                if (A[i] > R) prev = 0;
                else prev += (tempCount + 1);
                tempCount = 0;
            }
            count += prev;
        }
        return count;
    }
}
