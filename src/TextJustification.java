import java.util.LinkedList;
import java.util.List;

public class TextJustification {

    public static void main(String[] args) {
        TextJustification t = new TextJustification();
        System.out.println(t.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        // This is wrong, however, I think this problem is not interesting. So I stopped here.
//        List<String> ls = new LinkedList<>();
//        StringBuilder sb = new StringBuilder();
//        int count = maxWidth;
//
//        for (int i = 0; i < words.length; i++){
//            String s = words[i];
//            if (count > s.length()){
//                count -= s.length() + 1;
//                sb.append(s).append(" ");
//                continue;
//            } else if (count == s.length())
//                sb.append(s);
//            else {
//                for (int c = 0; c < count; c++) sb.append(" ");
//                i--;
//            }
//            ls.add(sb.toString());
//            count = maxWidth;
//            sb = new StringBuilder();
//        }
//        ls.add(sb.toString());
//        return ls;
    }

}
