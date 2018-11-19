import java.util.LinkedList;
import java.util.Stack;

public class ValidParenthese {

    public static void main(String[] args) {
        ValidParenthese v = new ValidParenthese();
        System.out.println(v.isValid("()"));

    }

//    public boolean isValid(String s) {
//        if (s.length() == 0) return true;
//        LinkedList<Character> heap = new LinkedList<>();
//        for (int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            if (heap.size() != 0 && (c == ')' || c == ']' || c == '}')){
//                if (!heap.removeLast().equals(c)) return false;
//            } else {
//                switch (c){
//                    case '(': heap.add(')'); break;
//                    case '[': heap.add(']'); break;
//                    case '{': heap.add('}'); break;
//                    default: return false;
//                }
//            }
//        }
//        return heap.size() == 0;
//    }

    public boolean isValid(String s){
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()){
            switch (c){
                case '(':
                    st.push(')'); break;
                case '[':
                    st.push(']'); break;
                case '{':
                    st.push('}'); break;
                default:
                    if (st.isEmpty() || st.pop() != c) return false;
            }
        }
        return st.isEmpty();
    }
}
