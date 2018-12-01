public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray f = new FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(f.searchRange(new int[] {5,7,7,8,8,10}, 8)[1]);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 1) return new int[] {-1, -1};
        int lo1 = 0, hi1 = nums.length - 1, lo2 = lo1, hi2 = hi1;
        int[] answer = new int[] {-2, -2};

        while (answer[0] == -2 || answer[1] == -2){
            int mid1 = lo1 + (hi1 - lo1) / 2;
            int mid2 = lo2 + (hi2 - lo2) / 2;

            if(hi1 - lo1 < 2) answer[0] = nums[lo1] == target ? lo1 : nums[hi1] == target ? hi1 : -1;
            if(hi2 - lo2 < 2) answer[1] = nums[hi2] == target ? hi2 : nums[lo2] == target ? lo2 : -1;

            if (nums[mid1] >= target) hi1 = mid1;
            else lo1 = mid1;

            if (nums[mid2] >
                    target) hi2 = mid2;
            else lo2 = mid2;

        }
        return answer;
    }


//    public int[] searchRangeHelper(int[] nums, int target, int lo, int hi) {
//        int mid = lo + (hi - lo) / 2;
//        if (nums[mid] == target) return searchRangeHelper(nums, target, mid, hi);
//        else if (nums[mid] < target) return searchRangeHelper(nums, target, mid, hi);
//        else if (nums[mid] > target) return searchRangeHelper(nums, target, lo, mid);
//    }

}
