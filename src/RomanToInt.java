public class RomanToInt {

    public static void main(String[] args) {
        RomanToInt roman = new RomanToInt();
        System.out.println(roman.romanToInt(""));
        System.out.println(roman.romanToInt("III"));
        System.out.println(roman.romanToInt("IV"));
        System.out.println(roman.romanToInt("IX"));
        System.out.println(roman.romanToInt("LVIII"));
        System.out.println(roman.romanToInt("MCMXCIV"));
    }

    /*
     *
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     * 
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * */
    public int romanToInt(String s) {
        int sum = 0, index = 0;

        while (index < s.length()) {
            if (s.charAt(index) == 'I') {
                if (index + 1 < s.length() && s.charAt(index + 1) == 'V') { sum += 4; index++;}
                else if (index + 1 < s.length() && s.charAt(index + 1) == 'X') { sum += 9; index++;}
                else sum += 1;

            }
            else if (s.charAt(index) == 'V') {sum += 5;}

            else if (s.charAt(index) == 'X') {
                if (index + 1 < s.length() && s.charAt(index + 1) == 'L') { sum += 40; index++;}
                else if (index + 1 < s.length() && s.charAt(index + 1) == 'C') { sum += 90; index++;}
                else sum += 10;
            }

            else if (s.charAt(index) == 'L') sum += 50;

            else if (s.charAt(index) == 'C') {
                if (index + 1 < s.length() && s.charAt(index + 1) == 'D') { sum += 400; index++;}
                else if (index + 1 < s.length() && s.charAt(index + 1) == 'M') { sum += 900; index++;}
                else sum += 100;
            }

            else if (s.charAt(index) == 'D') sum += 500;
            else if (s.charAt(index) == 'M') sum += 1000;

        index++;
        }

        return sum;
    }


}
