public class DivideTwoInteger {


    //Codes from
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
        if(dividend > 0 && divisor > 0) return divideHelper(-dividend, -divisor);
        else if(dividend > 0) return -divideHelper(-dividend,divisor);
        else if(divisor > 0) return -divideHelper(dividend,-divisor);
        else return divideHelper(dividend, divisor);
    }

    private int divideHelper(int dividend, int divisor){
        // base case
        if(divisor < dividend) return 0;
        // get highest digit of divisor
        int cur = 0, res = 0;
        while((divisor << cur) >= dividend && divisor << cur < 0 && cur < 31) cur++;
        res = dividend - (divisor << cur-1);
        return (1 << cur-1) +divide(res, divisor);
    }

//
//
//    public int divide(int dividend, int divisor) {
//        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
//        else if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
//
//        if (dividend < 0){
//            dividend = - dividend;
//            divisor = - divisor;
//        }
//
//        int index = 0;
//        if (dividend - divisor < dividend){
//            while (dividend >= 0){
//                dividend -= divisor;
//                index++;
//            }
//            index--;
//        } else {
//            while (dividend >= 0){
//                dividend += divisor;
//                index--;
//            }
//            index++;
//        }
//
//        return index;
//    }

}
