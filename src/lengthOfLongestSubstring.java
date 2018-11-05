import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring {

    public static void main(String[] args) {
        lengthOfLongestSubstring lengthOfLongestSubstring = new lengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> rec = new HashMap<>();
        int length = 0;
        int start = -1, end = 0;
        while (end < s.length()){
            if (rec.containsKey(s.charAt(end))){
                start = Math.max(start,rec.get(s.charAt(end)));
            }
            length = Math.max(length, end - start);
            rec.put(s.charAt(end), end);
            end++;
        }
        return length;
    }

}
