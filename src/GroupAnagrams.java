import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> maps = new HashMap<>();
        for (String s : strs){
            String countChar = countChar(s);
            if (maps.containsKey(countChar)) maps.get(countChar).add(s);
            else maps.put(countChar, generateSingleList(s));
        }
        return new LinkedList<>(maps.values());
    }

    private List<String> generateSingleList(String s) {
        List<String> list = new LinkedList<>();
        list.add(s);
        return list;
    }

    private String countChar(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++){
            counts[s.charAt(i) - 97] += 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++){
            if (counts[i] != 0)
                 sb.append((char) (i + 97)).append(counts[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        System.out.println(g.countChar("eat"));
    }

}
