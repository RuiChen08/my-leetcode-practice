import java.util.*;

public class Combinations {

    public static void main(String[] args) {
        Combinations c = new Combinations();
        System.out.println(c.combine(20, 16));
    }

    /**
     * https://leetcode.com/problems/combinations/
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new LinkedList<>();
        Stack<Integer> an = new Stack<>();
        helperF(ans, an, 1, n, k);
        return ans;
    }

    private void helperF(List<List<Integer>> ans, Stack<Integer> an, int s, int n, int k) {
        if (k == 0) ans.add(new LinkedList<>(an));
        for (int i = s; i <= n; i++){
            an.push(i);
            helperF(ans, an, i+1, n, k-1);
            an.pop();
        }
    }

}
