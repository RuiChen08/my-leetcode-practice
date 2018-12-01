import javax.security.auth.Subject;
import javax.xml.stream.FactoryConfigurationError;
import java.util.*;

public class StrStr {

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

    public static void main(String[] args) {
        StrStr s = new StrStr();
//        System.out.println(s.isHeadOf("ASDbdfhsfgasdf","ASD", 0));
//        System.out.println(s.isHeadOf("ASDbdfhsfgasdf","SDb", 1));
//        System.out.println(s.isHeadOf("ASDbdfhsfgasdf","dfhsf", 4));
//        System.out.println(s.isHeadOf("AS","ASD", 10));
//        System.out.println();

        System.out.println(s.findSubstring("wordgoodgoodgoodbestword", new String[] {"word","good","best","good"}));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> pos = new LinkedList<>();
        if (words.length == 0) return pos;

        // Build the HashMap
        HashMap<String, Integer> countWord = new HashMap<>();
        for (String word : words){
            if (countWord.containsKey(word)) countWord.put(word, countWord.get(word) + 1);
            else countWord.put(word, 1);
        }

        int lengthOfWord = words[0].length();
        for (int i = 0; i <= s.length() - lengthOfWord * words.length; i++){
            //Construct a linked list from the list words
            if (findSubStringHelper(s, countWord, i, lengthOfWord, words.length)) pos.add(i);
        }

        return pos;
    }

    private Boolean findSubStringHelper(String s, HashMap<String, Integer> words, int start, int wordLength, int totalLength) {
        HashMap<String, Integer> countWord = new HashMap<>();

        for (int i = 0; i < totalLength; i++){
            String subString = s.substring(start + i * wordLength, start + (i + 1) * wordLength);

            if (!words.containsKey(subString)) return false;
            int valueOfCount = words.get(subString);
            int newValueOfCount = 1;

            if (countWord.containsKey(subString)) {
                newValueOfCount = countWord.get(subString) + 1;
                countWord.put(subString, newValueOfCount);
            }
            else countWord.put(subString, newValueOfCount);

            if (newValueOfCount > valueOfCount) return false;
        }
        return true;
    }
//    private Boolean findSubStringHelper(String s, List<String> words, int start, int wordLength){
//        if (words.isEmpty()) return true;
//        Iterator<String> iterator =  words.iterator();
//
//        while (iterator.hasNext()){
//            String word = iterator.next();
//            if (isHeadOf(s, word, start) && word.length() == wordLength){
//                iterator.remove();
//                return findSubStringHelper(s, words, start + word.length(), wordLength);
//            }
//        }
//        return false;
//    }
//
//    private boolean isHeadOf(String haystack, String needle, int start){
//        if (haystack.length() - start < needle.length()) return false;
//        for (int i = 0; i < needle.length(); i++){
//            if (haystack.charAt(start + i) != needle.charAt(i)) return false;
//        }
//        return true;
//    }

}
