import java.util.*;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum c = new CombinationSum();
        System.out.println(c.combinationSum2(new int[] {2,5,2,2,2,1,2}, 5));

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

    // Leetcode problem 40
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answers = new LinkedList<>();

        combinationSumHelper2(candidates, target, 0, answers, new LinkedList<>(), new int[candidates.length]);
        return answers;
    }

    public void combinationSumHelper2(int[] candidates, int target, int cursor, List<List<Integer>> answers, LinkedList<Integer> answer, int[] indicate) {
        if (target < 0) return;
        for (int i = cursor; i < candidates.length; i++){
            if (i != 0 && indicate[i-1] == 0 && candidates[i] == candidates[i - 1]) continue;
            if (target - candidates[i] > 0) {
                answer.add(candidates[i]);
                indicate[i] = 1;
                combinationSumHelper2(candidates, target - candidates[i], i + 1, answers, answer, indicate);
                answer.remove(answer.size() - 1);
                indicate[i] = 0;
            }else if (target - candidates[i] == 0) {
                List<Integer> ll = new LinkedList<>(answer);
                ll.add(candidates[i]);
                answers.add(ll);
            }
        }
    }
}
