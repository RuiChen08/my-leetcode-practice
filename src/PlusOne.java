public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            if ((digits[i] = ++digits[i] % 10) != 0) return digits;
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        return ans;
    }
}
