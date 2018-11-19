import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
         FourSum f = new FourSum();
        System.out.println(f.fourSum(new int[] {-1,-5,-5,-3,2,5,0,4}, -7));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> ans = new LinkedList<>();
        if (nums.length < 4) return ans;
        
        for (int c = 0; c < nums.length - 3; c++) {

            if (c == 0 || (nums[c] != nums[c-1])) {
                for (int i = c + 1; i < nums.length - 2; i++) {

                    if (i == c + 1 || (nums[i] != nums[i - 1])) {
                        int lo = i + 1, hi = nums.length - 1, sum = target - nums[i] - nums[c];
                        while (lo < hi) {
                            if (nums[lo] + nums[hi] == sum) {

                                ans.add(Arrays.asList(nums[c], nums[i], nums[lo], nums[hi]));
                                while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                                while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                                lo++;
                                hi--;
                            } else if (nums[lo] + nums[hi] < sum) lo++;
                            else hi--;
                        }
                    }
                }
            }
        }

        return ans;
    }

}
