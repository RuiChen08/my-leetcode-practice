public class StrStr {

    public static void main(String[] args) {
        StrStr s = new StrStr();
        System.out.println(s.strStr("mississippi","issi"));
    }


    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        int i = 0, range = haystack.length() - needle.length();
        makeNext(needle, next);

        while(i <= range){
            int insideIndex = 0;
            while (insideIndex < needle.length() && haystack.charAt(i + insideIndex) == needle.charAt(insideIndex)) insideIndex++;
            if (insideIndex == needle.length()) return i;
            else i += insideIndex - next[insideIndex];
        }
        return -1;
    }

    public void makeNext(String subStr, int[] next){
        int len = subStr.length(), longestCommonSubStr = 0;
        if (len == 0) return;
        next[0] = -1;

        for(int i = 1; i < len - 1; i++){
            while (longestCommonSubStr > 0 && subStr.charAt(i) != subStr.charAt(longestCommonSubStr))
                longestCommonSubStr = next[longestCommonSubStr];
            if (subStr.charAt(i) == subStr.charAt(longestCommonSubStr))
                longestCommonSubStr++;
            next[i+1] = longestCommonSubStr;
        }
    }
}
