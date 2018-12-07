import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        System.out.println(j.jump(new int[] {2,3,1,1,4}));
    }

    public int jump(int[] nums) {
        int nlen = nums.length;
        if (nlen <= 1) return 0;

        int start = 1, end = start + nums[0], walk = 1;
        while (start < nlen) {
            int temp = end;
            for (;start < end && start < nlen; start++) {
                temp = Math.max(temp, 1 + start + nums[start]);
                nums[start] = walk;
            }
            end = temp;
            walk++;
        }
        return nums[nlen - 1];
    }

}
