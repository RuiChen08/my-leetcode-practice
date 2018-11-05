public class IntegerisPalindrome {

    public static void main(String[] args) {
        IntegerisPalindrome integerisPalindrome = new IntegerisPalindrome();
        System.out.println(integerisPalindrome.isPalindrome(121));
        System.out.println(integerisPalindrome.isPalindrome(1221));
        System.out.println(integerisPalindrome.isPalindrome( -121));
        System.out.println(integerisPalindrome.isPalindrome(10));
    }

    public boolean isPalindrome(int x) {
        String intString = x + "";
        for (int i = 0; i < intString.length(); i++){
            if (intString.charAt(i) != intString.charAt(intString.length() - 1 - i)) return false;
        }
        return true;
    }

}
