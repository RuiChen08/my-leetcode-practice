import java.util.*;

public class SimplifyPath {


    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append('/').append(stack.removeLast());
        return res.toString().isEmpty() ? "/" : res.toString();
    }

}
