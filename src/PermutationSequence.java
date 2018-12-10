import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {

    public static void main(String[] args) {
        PermutationSequence ps = new PermutationSequence();
        System.out.println(ps.getPermutation(3, 3));
    }



    public String getPermutation(int n, int k) {
        List<String> ch = new LinkedList<>();
        List<Integer> fac = new ArrayList<>(n+1);
        int sum = 1;
        fac.add(sum);
        //O(n)
        for (int i = 1; i <= n; i++){
            ch.add(i + "");
            sum *= i;
            fac.add(sum);
        }
        return getPermutationHelper(n, k - 1, ch, fac);
    }

    //O(n^2)
    public String getPermutationHelper(int n, int k, List<String> ch, List<Integer> fact){
        if (ch.isEmpty()) return "";
        int fac = fact.get(n - 1);
        return ch.remove(k / fac) + getPermutationHelper(n - 1, k % fac, ch, fact);
    }

}
