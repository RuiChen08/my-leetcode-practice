import java.util.*;

public class WeekContest115 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        WeekContest115 w = new WeekContest115();
        System.out.println(w.prisonAfterNDays(new int[] {1,0,0,1,0,0,1,0}, 15 + 14));

    }

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> qs = new LinkedList<>(Collections.singletonList(root));
        boolean seeNull = false;
        while (!qs.isEmpty()){
            root = qs.poll();
            if (root != null) {
                if (seeNull) return false;
                qs.add(root.left);
                qs.add(root.right);
            } else
                seeNull = true;
        }
        return true;
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        N= (N - 1) % 14 + 1;
        if (N == 0) return cells;
        for (int c = 0; c < N; c++) {
            int[] tempCell = new int[cells.length];
            tempCell[0] = 0;
            tempCell[cells.length - 1] = 0;
            for (int i = 1; i < cells.length - 1; i++) {
                if (cells[i - 1] == 0 && cells[i + 1] == 0) tempCell[i] = 1;
                else if (cells[i - 1] == 1 && cells[i + 1] == 1) tempCell[i] = 1;
            }
            cells = tempCell;
            for (int i : cells) System.out.print(i + " ");
            System.out.println();
        }
        for (int i : cells) System.out.print(i + " ");
        System.out.println();

        return cells;
    }
}
