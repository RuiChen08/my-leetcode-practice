/*
    Implement atoi which converts a string to an integer.

    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.
 */
public class MyAtoi {

    public static void main(String[] args) {
        MyAtoi myAtoi = new MyAtoi();
        System.out.println(myAtoi.myAtoi(""));
        System.out.println(myAtoi.myAtoi(" "));
        System.out.println(myAtoi.myAtoi("     -42"));
        System.out.println(myAtoi.myAtoi("4193 with words"));
        System.out.println(myAtoi.myAtoi("words and 987"));
        System.out.println(myAtoi.myAtoi("-91283472332"));
        System.out.println(myAtoi.myAtoi("2147483648"));
        System.out.println(myAtoi.myAtoi("-2147483649"));
        System.out.println(myAtoi.myAtoi("2147483646"));
    }

    public int myAtoi(String str) {

        if (str.length() == 0) return 0;

        int i = 0, sign = 1, total = 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;

        if (i < str.length() && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        if (i < str.length() && Character.isDigit(str.charAt(i))){
            while (i < str.length() && Character.isDigit(str.charAt(i))) {

                int digit = str.charAt(i) - '0';

                if ((Integer.MAX_VALUE - digit) / 10  < total){
                    if (sign < 0) return Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }

                total *= 10;
                total += digit;
                i++;
            }
            return sign * total;
        } else {
            return 0;
        }
    }

}
