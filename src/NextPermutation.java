import java.util.Arrays;
import java.util.List;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        n.nextPermutation(new int[] {1, 5, 1});
    }

    //
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        int pivotIndex, pointIndex, value;
        for (pivotIndex = nums.length - 2; pivotIndex >= 0 && nums[pivotIndex] >= nums[pivotIndex+1]; pivotIndex--);

        System.out.println(pivotIndex);

        if (pivotIndex >= 0) {
            value = nums[pivotIndex];
            for (pointIndex = nums.length - 1; nums[pointIndex] <= value; pointIndex--) ;

            nums[pivotIndex++] = nums[pointIndex];
            nums[pointIndex] = value;

        } else pivotIndex = 0;
        pointIndex = nums.length - 1;

        while (pivotIndex - pointIndex < 1){
            value = nums[pivotIndex];
            nums[pivotIndex++] = nums[pointIndex];
            nums[pointIndex--] = value;
        }
    }

}
