public class WeeklyContest116 {

    public int repeatedNTimes(int[] A) {
        int[] vals  =new int[10000];

        for (int in : A){
            vals[in]++;
            if (vals[in] > 1) return in;
        }
        return 0;
    }

    public int maxWidthRamp(int[] A) {
        int start, distance = A.length - 1;

        while (distance > 0) {
            start = 0;
            while (start + distance < A.length) {
                if (A[start] <= A[start + distance]) return distance;
                start++;
            }
            distance--;
        }
        return 0;
    }

//    public static void main(String[] args) {
//        WeeklyContest116 w = new WeeklyContest116();
//        System.out.println(w.leastOpsExpressTarget(3, 19));
//    }

//    int x;
//
//    public int leastOpsExpressTarget(int x, int target) {
//        this.x = x;
//        return leastOpsExpressTargetHelper(0, target);
//    }
//
//    public int leastOpsExpressTargetHelper(int i, int target){
//
//        int ans = 0;
//        if (target == 0)
//
//        if (target == 1) ans = 2;
//        else if (i >= 39) ans = Integer.MAX_VALUE;
//        else {
//            int rem = target % (int) Math.pow(x, i), div = target / (int) Math.pow(x, i);
//            ans = Math.min(
//                    rem * cost(i) + leastOpsExpressTargetHelper(i+1, target - (int) Math.pow(x, i)),
//                    (x - rem) * cost(i) + leastOpsExpressTargetHelper(i+1, target - (int) Math.pow(x, i));
//            );
//        }
//
//    }
//
//    public int cost(int x) {
//        return x > 0 ? x : 2;
//    }
}
