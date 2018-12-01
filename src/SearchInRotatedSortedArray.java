public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(new int[] {4,5,6,7,0,1,2}, 0));
    }

    //
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public int searchHelper(int[] nums, int target, int start, int end) {
        if (end - start < 2){
            return nums[start] == target ? start : nums[end] == target ? end : -1;
        }

        int mid = start  + (end - start) / 2;
        if (nums[mid] == target) return mid;

        if (nums[mid] > nums[start]){
            if (nums[start] <= target && target <= nums[mid])
                return searchHelper(nums, target, start, mid);
            else
                return searchHelper(nums, target, mid, end);
        } else {
            if (nums[mid] <= target && target <= nums[end])
                return searchHelper(nums, target, mid, end);
            else
                return searchHelper(nums, target, start, mid);

        }
    }

}
