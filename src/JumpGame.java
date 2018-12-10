import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        System.out.println(j.canJump(new int[] {1,2}));
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

    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) return false;
            reachable = Math.max(i + nums[i], reachable);
        }
        return true;
    }
}
