import java.util.LinkedList;
import java.util.Queue;

public class CountAndSay {

    public static void main(String[] args) {
        CountAndSay c = new CountAndSay();
        System.out.println(c.countAndSay(1));
        System.out.println(c.countAndSay(2));
        System.out.println(c.countAndSay(3));
        System.out.println(c.countAndSay(4));
        System.out.println(c.countAndSay(5));
        System.out.println(c.countAndSay(6));
    }

    public String countAndSay(int n) {
        StringBuilder countSay = new StringBuilder("1");

        for (int i = 1; i < n; i++){
            StringBuilder nextCountSay = new StringBuilder();
            int count = 0;
            for (int s = 0; s < countSay.length(); s++){
                if (s + 1 < countSay.length() && countSay.charAt(s) == countSay.charAt(s + 1)) count++;
                else{
                    nextCountSay.append(count + 1).append(countSay.charAt(s));
                    count=0;
                }
            }
            countSay = nextCountSay;
        }
        return countSay.toString();

    }
}
