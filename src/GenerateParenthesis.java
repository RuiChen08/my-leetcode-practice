import java.util.*;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(3));
    }

//    public List<String> generateParenthesis(int n) {
//        List<List<String>> pss = new ArrayList<>(n + 1);
//        for (int i = 0; i <= n; i++) {
//            //
//            List<String> ps = new LinkedList<>();
//
//            //
//            if (i == 0)
//                ps.add("");
//            else {
//                for (int c = 0; c < i; c++) {
//
//                    List<String> l1 = pss.get(c);
//                    List<String> l2 = pss.get(i - c - 1);
//
//                    for (String s1 : l1) {
//                        for (String s2 : l2) {
//                            ps.add("(" + s1 + ")" + s2);
//                        }
//                    }
//                }
//            }
//            pss.add(ps);
//        }
//        return pss.get(n);
//    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max){

        if(str.length() == max*2){
            list.add(str);
            return;
        }

        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }

}
