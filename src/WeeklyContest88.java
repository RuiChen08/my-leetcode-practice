import java.math.BigInteger;
import java.util.*;

public class WeeklyContest88 {


    public static void main(String[] args) {
        WeeklyContest88 w = new WeeklyContest88();
        System.out.println(w.rectangleArea(new int[][] {{0,0,1000000000,1000000000}}));
    }

    public int rectangleArea(int[][] rectangles) {
        BigInteger area = new BigInteger("0");
        for (int[] ins : rectangles){
            area = area.add(new BigInteger((ins[2] - ins[0])+"").multiply(new BigInteger((ins[3] - ins[1])+"")).mod(new BigInteger("1000000007")));
        }
        return Integer.parseInt(area.toString());
    }

    int[] dp;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int len = quiet.length;
        dp = new int[len];
        int[] newQuite = new int[len];

        Map<Integer, Set<Integer>> maps = new HashMap<>();

        for (int[] in : richer) {
            if (maps.containsKey(in[1])) maps.get(in[1]).add(in[0]);
            else maps.put(in[1], new HashSet<>(Arrays.asList(in[0])));
        }

        for (int i = 0; i < len; i++) dp[i] = -1;

        for (int i = 0; i < len; i++) newQuite[quiet[i]] = i;

        for (int i = 0; i < len; i++){
            dp(maps, i, quiet);
        }

        for (int i = 0; i < len; i++) dp[i] = newQuite[dp[i]];

        return dp;
    }

    private void dp(Map<Integer, Set<Integer>> maps, int i, int[] quiet) {
        if (dp[i] == -1) {
            int min = quiet[i];

            if (maps.containsKey(i)) {
                for (int in : maps.get(i)) {
                    if (dp[in] == -1) {
                        dp(maps, in, quiet);
                    }

                    min = Math.min(min, dp[in]);
                }
            }
            dp[i] = min;
        }
    }

    private int find(Map<Integer, List<Integer>> richers, int[] quiet, int i) {
        for (int q : quiet){
            if (q == i) return q;
            else if (isRicherThan(q, i, richers)) return q;
        }
        return i;
    }

    private boolean isRicherThan(int q, int i, Map<Integer,List<Integer>> richers) {
        if (!richers.containsKey(q)) return false;
        Queue<List<Integer>> asd = new LinkedList<>();
        asd.add(richers.get(q));

        while (!asd.isEmpty()) {
            List<Integer> ccc = asd.poll();
            if (ccc.contains(i)) return true;
            else for (int in : ccc) if (richers.containsKey(in)) asd.add(richers.get(in));
        }
        return false;
    }

    public int maxDistToClosest(int[] seats) {
        int max = 1;
        for (int i = 0; i < seats.length; i++){
            if (seats[i] == 0) max = Math.max(max, findMax(i, seats));
        }
        return max;
    }

    private int findMax(int i, int[] seats) {
        int low = i, high = low;
        while (low >= 0 && seats[low] != 1) low--;
        while (high < seats.length && seats[high] != 1) high--;
        return high == seats.length - 1 || low == 0 ? high - low - 1 : (high - low - 2) / 2 + 1;
    }


    public String shiftingLetters(String S, int[] shifts) {
        BigInteger sum = new BigInteger("0");
        for (int in : shifts) sum = sum.add(new BigInteger(in + ""));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++){
            sb.append(shift(S.charAt(i), sum));
            sum = sum.subtract(new BigInteger(shifts[i] + ""));
        }

        return sb.toString();


    }

    public char shift(char c, BigInteger times){
        int tt = Integer.parseInt(times.mod(new BigInteger("26")).toString());
        int con = tt + c;

        if (con> 'z') return (char) ('a' + (con - 'z' - 1));
        return (char) con;
    }

}
