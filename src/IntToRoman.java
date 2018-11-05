
/*
    Question 12 from Leetcode
 */

public class IntToRoman {
    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.intToRoman(0));
        System.out.println(intToRoman.intToRoman(1));
        System.out.println(intToRoman.intToRoman(2));
        System.out.println(intToRoman.intToRoman(3));
        System.out.println(intToRoman.intToRoman(4));
        System.out.println(intToRoman.intToRoman(9));
        System.out.println(intToRoman.intToRoman(58));
        System.out.println(intToRoman.intToRoman(1994));
    }

    /*
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
     */
     // Obviously greedy strategy
    public String intToRoman(int num) {
        if (num >= 1000)
            return "M" + intToRoman(num - 1000);
        else if (num >= 900)
            return "CM" + intToRoman(num - 900);
        else if (num >= 500)
            return "D" + intToRoman(num - 500);
        else if (num >= 400)
            return "CD" + intToRoman(num - 400);
        else if (num >= 100)
            return "C" + intToRoman(num - 100);
        else if (num >= 90)
            return "XC" + intToRoman(num - 90);
        else if (num >= 50)
            return "L" + intToRoman(num - 50);
        else if (num >= 40)
            return "XL" + intToRoman(num - 40);
        else if (num >= 10)
            return "X" + intToRoman(num - 10);
        else if (num >= 9)
            return "IX" + intToRoman(num - 9);
        else if (num >= 5)
            return "V" + intToRoman(num - 5);
        else if (num >= 4)
            return "IV" + intToRoman(num - 4);
        else if (num >= 1)
            return "I" + intToRoman(num - 1);
        return "";
    }
}
