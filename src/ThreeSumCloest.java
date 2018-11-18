import java.util.Arrays;

public class ThreeSumCloest {

    public static void main(String[] args) {
        ThreeSumCloest s = new ThreeSumCloest();
        System.out.println(s.threeSumClosest(new int[] {-1, 2, 1, 4}, 1));
    }

    // Calculate the sum
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE, value = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++){
            if (i == 0 || (nums[i] != nums[i-1])){
                int lob = i+1, hib = nums.length - 1, diff = target - nums[i];

                while (lob < hib){
                    int temp = diff - nums[lob] - nums[hib];
                    if (Math.abs(temp) < min) {min = Math.abs(temp); value = nums[i] + nums[lob] + nums[hib];}
                    if (temp > 0) lob++;
                    else hib--;
                }
            }
        }
        return value;
    }
}
