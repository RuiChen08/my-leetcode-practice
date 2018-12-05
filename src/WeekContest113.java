import java.util.*;

public class WeekContest113 {

    public String largestTimeFromDigits(int[] A) {

        int index;

        HashMap<Integer, Integer> timeCount = new HashMap<>();

        for (int i : A) {
            if (timeCount.containsKey(i)) timeCount.put(i, timeCount.get(i) + 1);
            else timeCount.put(i, 1);
        }

        for (int a = 2; a >= 0; a--) {
            if (a == 2) index = 3;
            else index = 9;

            if (!timeCount.containsKey(a)) continue;
            timeCount.put(a, timeCount.get(a) - 1);

            for (int b = index; b >= 0; b--) {

                if (!timeCount.containsKey(b) || timeCount.get(b) < 1) continue;
                timeCount.put(b, timeCount.get(b) - 1);

                for (int c = 5; c >= 0; c--) {

                    if (!timeCount.containsKey(c) || timeCount.get(c) < 1) continue;
                    timeCount.put(c, timeCount.get(c) - 1);

                    for (int d = 9; d >= 0; d--) {

                        if (!timeCount.containsKey(d) || timeCount.get(d) < 1) continue;
                        return "" + a + b + ":" + c + d;

                    }

                    timeCount.put(c, timeCount.get(c) + 1);

                }

                timeCount.put(b, timeCount.get(b) + 1);
            }
            timeCount.put(a, timeCount.get(a) + 1);
        }

        return "";
    }

    //
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null) return false;
        return root1.val == root2.val &&
                ((flipEquiv(root1.left, root2.left) &&
                flipEquiv(root1.right, root2.right))
                ||
                (flipEquiv(root1.left, root2.right) &&
                        flipEquiv(root1.right, root2.left)));
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        if (deck.length <= 1) return deck;
        Arrays.sort(deck);
        Stack<Integer> decks = new Stack<>();

        for (int i : deck) decks.add(i);

        //
        Queue<Integer> returnList = new LinkedList<>();

        returnList.add(decks.pop());
        returnList.add(decks.pop());

        while(!decks.isEmpty()) {
            Integer temp = returnList.poll();
            returnList.add(temp);
            returnList.add(decks.pop());
        }

        int[] theList = new int[returnList.size()];
        for (int i = theList.length - 1; i >= 0; i--){
            theList[i] = returnList.poll();
        }

        return theList;
    }

    public static void main(String[] args) {
        WeekContest113 w = new WeekContest113();
        System.out.println(w.largestComponentSize(new int[] {65,35,43,76,15,11,81,22,55,92,31}));
    }

    public int largestComponentSize(int[] A) {
        DisjointSet d = new DisjointSet(A.length);

        for (int i = 0; i < A.length; i++) {
            d.makeSet(i);
        }

        for (int i = 0; i < A.length; i++){
            for (int c = i; c < A.length; c++){
                if (GCD(A[i], A[c]) > 1) d.union(i, c);
            }
        }

        HashMap<Integer, Integer> keys = new HashMap<>();
        for (int i : d.parent){
            i = d.find(i);
            if (keys.containsKey(i)) keys.put(i, keys.get(i) + 1);
            else keys.put(i, 1);
        }

        int larValue = 0;
        for (int value : keys.values()){
            larValue = Math.max(larValue, value);
        }

        return larValue;
    }

    public static int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }

    // Author: Rui Chen
    // Disjoint set
    static class DisjointSet{

        int[] parent;
        int[] rank;

        public DisjointSet(int size) {
            parent = new int[size];
            rank = new int[size];
        }

        void makeSet(int key){
            // Assuming the keys were given consecutively
            parent[key] = key;
            rank[key] = 0;
        }

        void union(int x, int y){
            int x_root = find(x);
            int y_root = find(y);

            //x and y are already in the same tree
            if (x_root == y_root) return;

            if (rank[x_root] < rank[y_root]) parent[x_root] = y_root;
            else parent[y_root] = x_root;

            if (rank[y_root] == rank[x_root]) rank[x_root] += 1;
        }

        int find(int key) {
            //Path compression
            if (parent[key] != key) parent[key] = find(parent[key]);
            return parent[key];
        }

        boolean connected() {
            for(int i = 0; i < parent.length - 1; i++){
                if (find(i) != find(i+1)) return false;
            }
            return true;
        }
    }



}
