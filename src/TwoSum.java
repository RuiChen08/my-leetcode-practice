import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[] {3,2,4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) maps.put(nums[i], i);
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (maps.containsKey(complement) && maps.get(complement) != i){
                return new int[] {i, maps.get(complement)};
            }
        }
        return nums;
    }
}
