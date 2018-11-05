public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(1534236469));
    }

    public long reverse(int x) {
        try {
            StringBuilder reversed = new StringBuilder();
            if (x < 0) {
                reversed.append('-');
            }
            String value = x < 0 ? -x + "" : x + "";
            for (int i = value.length() - 1; i >= 0; i--) {
                reversed.append(value.charAt(i));
            }
            return Integer.parseInt(reversed.toString());
        } catch (NumberFormatException e){
            return 0;
        }
    }
}
