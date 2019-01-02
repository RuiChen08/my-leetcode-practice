public class SortColors {

    /**
     * https://leetcode.com/problems/sort-colors/
     */
    public void sortColors(int[] nums) {
        int lo = 0;

        for (int target = 0; target < 3; target++) {
            int hi = lo;
            while (hi < nums.length) {
                if (nums[hi] == target) {
                    exchange(nums, lo, hi);
                    lo++;
                }
                hi++;
            }
        }
    }

    private void exchange(int[] nums, int lo, int hi) {
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }

}
