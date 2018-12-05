import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum(new int[] {2,3,6,7}, 7));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answers = new LinkedList<>();

        combinationSumHelper(candidates, target, 0, answers, new LinkedList<>());
        return answers;
    }

    private void combinationSumHelper(int[] candidates, int target, int cursor, List<List<Integer>> answers, List<Integer> answer) {
        if (target < 0) return;
        for (int i = cursor; i < candidates.length; i++){
            if (target - candidates[i] > 0) {
                answer.add(candidates[i]);
                combinationSumHelper(candidates, target - candidates[i], i, answers, answer);
                answer.remove(answer.size() - 1);
            }else if (target - candidates[i] == 0) {
                List<Integer> ll = new LinkedList<>(answer);
                ll.add(candidates[i]);
                answers.add(ll);
            }
        }
    }

}
