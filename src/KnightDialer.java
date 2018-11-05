import java.util.Arrays;
import java.util.Scanner;

public class KnightDialer {

    public static void main(String[] args) {
        KnightDialer knightDialer = new KnightDialer();

        Scanner scan = new Scanner(System.in);
        scan.next();
        for (int i = 1; i <= 5000; i++) System.out.println(knightDialer.knightDialer(i));
//        System.out.println(knightDialer.knightDialer(2));
//        System.out.println(knightDialer.knightDialer(50));
//        System.out.println(10^9 + 7);
//        System.out.println(Integer.MAX_VALUE);
    }

    public int knightDialer(int N) {
        long sum = 0;
        long[][] values = new long[10][N];
        for (int i = 0; i <= 9; i++){
            values[i][0] = 1L;
        }

        long mod = 1000000007;

        for (int v = 1; v < N; v++){
            values[0][v] = (values[4][v - 1] + values[6][v - 1]) % mod;
            values[1][v] = (values[6][v - 1] + values[8][v - 1]) % mod;
            values[2][v] = (values[7][v - 1] + values[9][v - 1]) % mod;
            values[3][v] = (values[4][v - 1] + values[8][v - 1]) % mod;
            values[4][v] = (values[3][v - 1] + values[9][v - 1] + values[0][v - 1]) % mod;
            values[5][v] = 0;
            values[6][v] = (values[1][v - 1] + values[7][v - 1] + values[0][v - 1]) % mod;
            values[7][v] = (values[2][v - 1] + values[6][v - 1]) % mod;
            values[8][v] = (values[1][v - 1] + values[3][v - 1]) % mod;
            values[9][v] = (values[2][v - 1] + values[4][v - 1]) % mod;
        }
        for (int i = 0; i <= 9; i++){
            sum += (values[i][N - 1]) % mod;
        }
        return (int) (sum % mod);
    }
//
//    public int helper(int N, int count){
//        if (count == 0) return 1;
//        switch (N){
//            case 0:
//                return helper(4, count - 1) + helper(6, count - 1);
//            case 1:
//                return helper(6, count - 1) +   helper(8, count - 1);
//            case 2:
//                return helper(7,count - 1) +   helper(9,count - 1);
//            case 3:
//                return helper(4,count - 1) +   helper(8,count - 1);
//            case 4:
//                return helper(3,count - 1) +   helper(9,count - 1) + helper(0, count - 1);
//            case 6:
//                return helper(1,count - 1) +   helper(7,count - 1) + helper(0,count - 1);
//            case 7:
//                return helper(2,count - 1) +   helper(6,count - 1);
//            case 8:
//                return helper(1,count - 1) +   helper(3,count - 1);
//            case 9:
//                return helper(2,count - 1) +   helper(4,count - 1);
//            default:
//                return 0;
//        }
//    }

}
