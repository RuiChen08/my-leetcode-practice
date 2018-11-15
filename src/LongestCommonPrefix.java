public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(l.longestCommonPrefix(new String[] {"dog","racecar","car"}));
        System.out.println(l.longestCommonPrefix(new String[] {"flower","flow",""}));
        System.out.println(l.longestCommonPrefix(new String[] {"a","b","a"}));
        System.out.println(l.longestCommonPrefix(new String[] {"a"}));
        System.out.println(l.longestCommonPrefix(new String[] {}));
        System.out.println(l.longestCommonPrefix(new String[] {"aasdadgasd"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int index = 0;
        String commonString = "";

        String s1 = strs[0];
        String s2 = strs[1];
        // Finding the two string with minimal length
        for (String s : strs){
            if (s.length() < s1.length()) s1 = s;
            else if (s.length() < s2.length()) s2 = s;
        }

        while (index < Math.min(s1.length(), s2.length())){
            if (s1.charAt(index) != s2.charAt(index)) break;
            index++;
        }
        commonString = s1.substring(0, index);

        for (String s : strs){
            while (index != 0 && !s.substring(0, index).equals(commonString)){
                index--;
                commonString = commonString.substring(0, index);
            }
            if (index == 0) break;
        }

        return commonString;

    }

}
