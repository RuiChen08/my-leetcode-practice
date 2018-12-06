public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length){

            if (nums[i] - 1 >= 0 && nums[i] - 1 < nums.length && nums[i] != nums[nums[i] - 1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else i++;
        }

        for (i = 0; i < nums.length; i++){
            if (nums[i] != i+1) break;
        }
        return i+1;
    }

}
