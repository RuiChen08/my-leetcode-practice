public class AddBinary {

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        StringBuilder s = new StringBuilder();
        int n = Math.max(a.length(), b.length()), in;
        int cur = 0;

        for (in = 1; in <= n; in++){
            int c = getSum(getChar(a, a.length() - in), getChar(b, b.length() - in), cur);
            s.append(c % 2);
            cur = c / 2;
        }

        if (cur != 0) s.append(cur);
        return s.reverse().toString();
    }

    private int getSum(char aChar, char bChar, int cur) {
        return cur + aChar + bChar - 2 * '0';
    }

    private char getChar(String a, int i) {
        if (i < 0) return '0';
        return a.charAt(i);
    }

}
