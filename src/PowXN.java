public class PowXN {

    public double myPow(double x, int n) {
        if (n < 0) return x * myPow(x, n + 1);
        if (n == 0) return 1;
        return n % 2 == 1 ? x * myPow(   x * x, n / 2) : myPow(x*x, n / 2);

//        if(n==0) return 1;
//        if (n == Integer.MIN_VALUE){
//            n = n + 1;
//            x = x * x;
//        }
//            if(n<0) {
//                n = -n;
//                x = 1/x;
//            }
//        double ans = 1;
//        while(n>0){
//            if((n & 1) == 1) ans *= x;
//            x *= x;
//            n >>= 1;
//        }
//        return ans;
    }
}
