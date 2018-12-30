import java.util.*;

public class WeelyContest117 {

    public static void main(String[] args) {
        WeelyContest117 w = new WeelyContest117();
        for (String s : w.spellchecker(
                new String[] {"ae","aa"},
                new String[] {"UU"}

        )) System.out.print(s + ",");
    }

    public int minCameraCover(TreeNode root) {
        if (root.left == null && root.right == null) return 1;
        return helper(root.left, true) + helper(root.right, true);
    }

    private int helper(TreeNode root, boolean b) {
        if (root == null) return 0;
        else if (b) return 1 + helper(root.left, false) + helper(root.right, false);
        else return helper(root.left, false) + helper(root.right, false);
    }


    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String, List<String>> maps = new HashMap<>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        for (String words : wordlist){
            String hash = hashing(words);
            if (maps.containsKey(hash)) maps.get(hash).add(words);
            else maps.put(hash, new LinkedList<>(Collections.singletonList(words)));
        }

        List<String> ans = new LinkedList<>();
        for (String q : queries){
            String hash = hashing(q);
            if (maps.containsKey(hash)){
                List<String> candidates = maps.get(hash);

                boolean flag = true;
                int indicator = -1;
                String temp = "";
                for (String w : candidates) {
                    int ind = matchWord(q, w);
                    if (ind != -1){
                        if (ind == 2){
                            ans.add(w);
                            flag=false;
                            break;
                        }
                        else if (ind > indicator) {
                            temp = w;
                            indicator = ind;
                        }
                    }
                }
                if (flag) ans.add(temp);

            }else ans.add("");
        }
        return ans.toArray(new String[ans.size()]);
    }

    private String hashing(String words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length(); i++){
            if (vowels.contains(Character.toLowerCase(words.charAt(i)))) sb.append('a');
            else sb.append(Character.toLowerCase(words.charAt(i)));
        }
        return sb.toString();
    }

    Set<Character> vowels = new HashSet<>();

    private int matchWord(String q, String w) {
        boolean cap = false, vol = false;
        if (q.length() != w.length()) return -1;

        for (int i = 0; i < q.length(); i++){
            if (q.charAt(i) == w.charAt(i)) continue;
            else{
                char qchar = Character.toLowerCase(q.charAt(i));
                char wchar = Character.toLowerCase(w.charAt(i));
                if (qchar != wchar) {
                    if (!(vowels.contains(qchar) && vowels.contains(wchar))) return -1;
                    vol = true;
                }
                cap = true;
            }
        }

        return cap ? vol ? 0: 1 : 2;
    }

    public int[] numsSameConsecDiff(int N, int K) {
        if (N == 0) return new int[] {};

        Queue<String> ans = new LinkedList<>();

        if (N == 1)
            for (char i = '0'; i <= '9'; i++) ans.add(String.valueOf(i));
        else
            for (char i = '1'; i <= '9'; i++) ans.add(String.valueOf(i));

        for (int i = 1; i < N; i++){
            LinkedList<String> temp = new LinkedList<>();
            while (!ans.isEmpty()) {

                String str = ans.poll();
                char chr = str.charAt(str.length() - 1);
                if (chr + K <= '9') temp.add(String.valueOf(str + (char) (chr + K)));
                if (K != 0 && chr - K >= '0') temp.add(String.valueOf(str + (char) (chr - K)));
            }
            ans.addAll(temp);
        }

        int[] anss = new int[ans.size()];
        int i = 0;
        for (String s : ans) {
            anss[i] = Integer.parseInt(s);
            i++;
        }

        return anss;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        int value = root.val;
        return isUnivalTreeHelper(root.left, value) && isUnivalTreeHelper(root.right, value);

    }

    private boolean isUnivalTreeHelper(TreeNode root, int value) {
        if (root == null) return true;
        return root.val == value && isUnivalTreeHelper(root.left, value) && isUnivalTreeHelper(root.right, value);
    }

}
