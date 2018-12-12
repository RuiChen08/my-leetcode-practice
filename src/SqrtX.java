import java.math.BigInteger;

public class SqrtX {

    public static void main(String[] args) {
        SqrtX s = new SqrtX();
        System.out.println(s.mySqrt(2147395600));
    }

    public int mySqrt(int x) {
        int lo = 0, hi = x;
        while (hi - lo > 1){
            int mid = lo + (hi - lo) / 2;
            if (mid > x / mid) hi = mid;
            else lo = mid;
        }
        if (hi < x / hi) return hi;
        return lo;
    }

}
