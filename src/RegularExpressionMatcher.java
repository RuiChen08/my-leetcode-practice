public class RegularExpressionMatcher {

    public static void main(String[] args) {
        RegularExpressionMatcher regularExpressionMatcher = new RegularExpressionMatcher();
        regularExpressionMatcher.isMatch("abc", "c*a*b");
    }

    public boolean isMatch(String s, String p) {
        int len = Math.max(s.length(), p.length());

        for (int i = 0; i < len; i++){

        }

        return true;

    }
}
