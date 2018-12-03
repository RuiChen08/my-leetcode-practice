import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku v = new ValidSudoku();
        System.out.println(v.isValidSudoku(
                new char[][]
                        {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}

        ));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++){
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> col = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.' && !row.add(board[r][c])) return false;
                if (board[c][r] != '.' && !col.add(board[c][r])) return false;
                int cubeR = c % 3;
                int cubeC = c / 3;
                if (board[cubeR + 3 * (r / 3)][cubeC + 3 * (r % 3)] != '.' && !cube.add(board[cubeR + 3 * (r / 3)][cubeC + 3 * (r % 3)])) return false;
            }
        }
        return true;
    }

}
