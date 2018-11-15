import java.lang.reflect.Array;
import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
//        System.out.println(ts.threeSum(new int[] {-1, 0, 1, 2, -1, -4}));
//        System.out.println(ts.threeSum(new int[] {0,0,0,0}));
        System.out.println(ts.threeSum(new int[] {1,2,-2,-1}));
    }

// Following codes from leetcode discussion formula, which has a better actual running time, but same time complexity
// https://leetcode.com/problems/3sum/discuss/7380/Concise-O(N2)-Java-solution

    // My codes:
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> solution = new LinkedList<>();

        if (nums.length < 3) return solution;

        for (int c = 0; c < nums.length; c++) {
            if (c == 0 || nums[c] != nums[c-1]) {

                HashMap<Integer, Integer> maps = new HashMap<>();
                // Building the map for using hash for O(1) get
                for (int i = c; i < nums.length; i++) maps.put(nums[i], i);
                //
                for (int i = c + 1; i < nums.length; i++){
                    if (i == c + 1 || nums[i] != nums[i-1]) {
                        int complement = 0 - nums[c] - nums[i];
                        if (maps.containsKey(complement) && maps.get(complement) > i) {
                            solution.add(Arrays.asList(nums[i], complement, nums[c]));
                        }
                        //
                    }
                }
            }
        }
        return solution;
    }


    public List<List<Integer>> generalSum(int[] nums, int parts, int target, int head){
        List<List<Integer>> solution = new ArrayList<>();
        if (nums.length - head < parts) return solution;

        if (parts == 2){
            HashMap<Integer, Integer> maps = new HashMap<>();
            // Building the map for using hash for O(1) get
            for (int i = head; i < nums.length; i++) maps.put(nums[i], i);
            //
            for (int i = head; i < nums.length; i++){
                if (i == head || nums[i] != nums[i-1]) {
                    int complement = target - nums[i];
                    List<Integer> tempList = new ArrayList<>();
                    if (maps.containsKey(complement) && maps.get(complement) > i) {
                        tempList.add(nums[i]);
                        tempList.add(complement);
                    }
                    //
                    if (tempList.size() != 0) solution.add(tempList);
                }
            }
        } else {
            // Note here I am not pretty sure
            for (int i = head; i < nums.length; i++) {
                if (i == head || nums[i] != nums[i-1]) {
                    for (List<Integer> li : generalSum(nums, parts - 1, target - nums[i], i + 1)) {
                        li.add(nums[i]);
                        solution.add(li);
                    }
                }
            }
        }

//        System.out.println(solution);

        return solution;
    }

}
