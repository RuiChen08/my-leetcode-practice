public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        
        int lo = 0, hi = nums.length - 1;
        while (hi - lo > 2){
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) lo = mid;
            else if (nums[mid] > target) hi = mid;
        }

        return nums[lo] <= target ? lo : nums[hi] <= target ? hi : hi + 1;
    }

}
