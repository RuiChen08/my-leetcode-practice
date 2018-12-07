import java.util.function.Consumer;

public class WildcardMatching {

    public static void main(String[] args) {


        WildcardMatching w = new WildcardMatching();
        System.out.println(w.adapter(""
                ,""));
        System.out.println(w.adapter("a"
                ,""));
        System.out.println(w.adapter(""
                ,"**"));
        System.out.println(w.adapter("aa"
                ,"**"));
        System.out.println(w.adapter("cb"
                ,"?a"));
        System.out.println(w.adapter("adceb"
                ,"*a*b"));
        System.out.println(w.adapter("aaa"
                ,"a*a"));
        System.out.println(w.adapter("aaaa"
                ,"aa"));
    }

    public boolean adapter(String s, String p){
        return isMatch2(s, p);
    }


    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;
        for (int i = 0; i < p.length(); i++){
            if (p.charAt(i) != '*') break;
            match[0][i + 1] = true;
        }
        for (int pi = 0; pi < p.length(); pi++){
            for (int si = 0; si < s.length(); si++){
                if (p.charAt(pi) == s.charAt(si) || p.charAt(pi) == '?')
                    match[si + 1][pi + 1] = match[si][pi];
                else if (p.charAt(pi) == '*')
                    match[si + 1][pi + 1] = match[si][pi + 1] || match[si + 1][pi];
            }
        }
        return match[s.length()][p.length()];
    }

    /*
    !!!
    Idea from here: https://leetcode.com/problems/wildcard-matching/discuss/17811/My-three-C%2B%2B-solutions-(iterative-(16ms)-and-DP-(180ms)-and-modified-recursion-(88ms))
    !!!
     */
    public boolean isMatch2(String s, String p) {
        int si = 0, pi = 0, sStar = -5, pStart = -5;

        while (si < s.length()) {
            if (getChar(p, pi) != '*'){
                if (!isMatchCharacter(s.charAt(si), getChar(p, pi))){
                    if (sStar >= 0){
                        si = sStar++;
                        pi = pStart;
                    }else return false;
                }
                si++;
                pi++;
            } else {
                sStar = si;
                pStart = pi;
                pi++;
            }
        }
        while (getChar(p, pi) == '*') pi++;
        return pStart == p.length() - 1 || (si == s.length() && pi == p.length());
    }

    private boolean isMatchCharacter(char c, char p){
        return c == p || p == '?';
    }

    private char getChar(String p, int i){
        if (i >= p.length()) return ' ';
        else return p.charAt(i);
    }
}