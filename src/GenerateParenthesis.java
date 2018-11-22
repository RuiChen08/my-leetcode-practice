import java.util.*;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<List<String>> pss = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            //
            List<String> ps = new LinkedList<>();

            //
            if (i == 0)
                ps.add("");
            else {
                for (int c = 0; c < i; c++) {

                    List<String> l1 = pss.get(c);
                    List<String> l2 = pss.get(i - c - 1);

                    for (String s1 : l1) {
                        for (String s2 : l2) {
                            ps.add("(" + s1 + ")" + s2);
                        }
                    }
                }
            }
            pss.add(ps);
        }
        return pss.get(n);
    }

}
