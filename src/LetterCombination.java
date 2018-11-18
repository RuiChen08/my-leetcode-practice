import java.util.LinkedList;
import java.util.List;

public class LetterCombination {

    public static void main(String[] args) {
        LetterCombination l = new LetterCombination();
        System.out.println(l.letterCombinations("23"));
        System.out.println(l.letterCombinations("23"));
    }

    //O(n^3)???
    public List<String> letterCombinations(String digits) {
        LinkedList<String> letters = new LinkedList<>();
        if (digits.isEmpty()) return letters;
        letters.add("");

        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while (letters.peek().length() == i){
                String s = letters.poll();
                for (Character c : mapping[x].toCharArray()) letters.add(s+c);
            }
        }
        return letters;
    }

}
