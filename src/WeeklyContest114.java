import java.util.*;

public class WeeklyContest114 {

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++){
            if (!sorted(words[i], words[i+1], order)) return false;
        }
        return true;
    }

    private boolean sorted(String word1, String word2, String order) {
        for (int i = 0; i < word1.length(); i++){
            if (i == word2.length()) return false;
            else if (word1.charAt(i) == word2.charAt(i)) continue;
            else if (!findOrder(word1.charAt(i), word2.charAt(i), order)) return false;
            else return true;
        }
        return true;
    }

    private boolean findOrder(char at1, char at2, String order) {
        for (int i = 0; i < order.length(); i++){
            if (order.charAt(i) == at2) return false;
            else if (order.charAt(i) == at1) break;
        }
        return true;
    }

    public static void main(String[] args) {
        WeeklyContest114 w = new WeeklyContest114();
//        System.out.println(w.canReorderDoubled(new int[] {3,1,3,6}));
//        System.out.println(w.canReorderDoubled(new int[] {2,1,2,6}));
//        System.out.println(w.canReorderDoubled(new int[] {4,-2,2,-4}));
//        System.out.println(w.canReorderDoubled(new int[] {1,2,4,16,8,4}));
//        System.out.println(w.canReorderDoubled(new int[] {1,2}));
//        System.out.println(w.canReorderDoubled(new int[] {1}));
//        System.out.println(w.canReorderDoubled(new int[] {0, 0}));
//        System.out.println(w.canReorderDoubled(new int[] {-11,2,38,-3,-98,-42,-22,-84,4,36,28,-40,-20,-10,36,-6,-49,-5,19,14}));
//        System.out.println(w.canReorderDoubled(new int[] {33,-11,72,40,-3,78,-6,36,-12,32,64,-22,7,66,-92,14,-50,80,23,-100,35,-25,40,-40,-46,18,-15,-20,-24,-70,40,-12,82,-34,41,36,-98,-50,96,-30,-35,-49,-24,35,-68,-24,48,-6,46,-12,39,-22,-12,70,80,36,80,70,-22,18}));
    }

    public int minDeletionSize(String[] A) {
        if (A.length <= 1) return 0;

        int n = A[0].length(), count = 0;
        int[] index = new int[A.length];
        int[] index2 = new int[A.length];


        for (int i = 0; i < n; i++){
            for (int c = 0; c < A.length - 1; c++){
                if (index[c] == 1) continue;

                if (A[c].charAt(i) > A[c+1].charAt(i)){
                    count++;
                    for (int w = 0; w < index.length; w++){
                        if (index2[w] == i) index[w] = 0;
                    }
                    break;
                } else if (A[c].charAt(i) < A[c+1].charAt(i)){
                    index[c] = 1;
                    index2[c] = i;
                }
            }
        }
        return count;
    }



}
