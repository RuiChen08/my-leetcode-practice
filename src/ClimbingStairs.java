public class ClimbingStairs {

    public int climbStairs(int n) {
        int p1 = 1, p2 = 1;
        for (int i = 1; i < n; i++){
            int temp = p1 + p2;
            p1 = p2;
            p2 = temp;
        }
        return p2;
    }

}
