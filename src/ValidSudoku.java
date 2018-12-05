import java.util.HashSet;

public class ValidSudoku {

    public static void main(String[] args) {
        ValidSudoku v = new ValidSudoku();
        v.solveSudoku(
                new char[][]
                        {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}}

        );
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

    public boolean isValidSudokuMirror(char[][] board, int start, char c) {
        int a = start / 9;
        int b = start % 9;
        int cubeS = (a / 3) * 27 + 3 * (b / 3);

        for (int r = 0; r < 9; r++){

            if (board[a][r] != '.' && board[a][r] == c) return false;
            if (board[r][b] != '.' && board[r][b] == c) return false;
            int cubeR = cubeS / 9 + r / 3;
            int cubeC = cubeS % 9 + r % 3;
            if (board[cubeR][cubeC] != '.' && board[cubeR][cubeC] == c) return false;
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board, 0);
    }


    public boolean solveSudokuHelper(char[][] board, int start) {
        int r = start / 9;
        int c = start % 9;

        while (start < 81 && board[r][c] != '.') {
            start++;
            r = start / 9;
            c = start % 9;
        }

        if (start == 81) return true;

        for (char i = '1'; i <= '9'; i++){
            if (isValidSudokuMirror(board, start, i)){
                board[r][c] = i;
                if (solveSudokuHelper(board, start + 1)) return true;
                else board[r][c] = '.';
            }
        }

        return false;
    }
}

