public class RemoveDuplicatesFromSortedArray {

//    public int removeDuplicates(int[] nums) {
//        if (nums.length == 0) return 0;
//        int pivot = 0;
//        for (int i = 1; i < nums.length; i++){
//            if (nums[i] != nums[pivot]) nums[++pivot] = nums[i];
//        }
//        return pivot+1;
//    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
     */
    public int removeDuplicates(int[] nums) {
        int lo = 2;

        while (lo < nums.length && nums[lo - 2] != nums[lo]) lo++;

        int hi = lo + 1;

        while (hi < nums.length){
            if ((nums[lo-1] != nums[hi]) || (nums[lo-1] == nums[hi] && nums[lo-1] != nums[lo-2])) {
                nums[lo] = nums[hi];
                lo++;
            }
            hi++;
        }
        return lo;
    }

}
