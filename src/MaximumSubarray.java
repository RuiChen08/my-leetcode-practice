public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        System.out.println(m.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        int val = nums[0], max = val;

        for (int i = 1; i < nums.length; i++){
            val = nums[i] + (val > 0 ? val : 0);
            max = Math.max(max, val);
        }

        return max;
    }

}
