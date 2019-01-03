import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        System.out.println(w.exist(
                new char[][] {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}},
                "aaaaaaaaaaaaa"
        ));
    }

    /**
     * https://leetcode.com/problems/word-search/
     */
    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;

        for (int r = 0; r < board.length; r++){
            for (int c = 0; c < board[0].length; c++){
                if (board[r][c] == word.charAt(0) && helperF(board, r, c, word, 1, new HashSet<>(Collections.singleton(r+":"+c)))) return true;
            }
        }
        return false;
    }

    private boolean helperF(char[][] board, int r, int c, String word, int index, Set<String> con) {
        if (index == word.length()) return true;
        if (con.add((r - 1) + ":" + c)){
            if (getChar(board, r - 1, c) == word.charAt(index)) {
                if (helperF(board, r - 1, c, word, index + 1, con))
                    return true;
            }
            con.remove((r - 1) + ":" + c);
        }
        if (con.add((r+1)+":"+c)){
            if (getChar(board, r+1, c) == word.charAt(index)){
                if (helperF(board, r + 1, c, word, index + 1, con))
                    return true;
            }
            con.remove((r+1)+":"+c);
        }
        if (con.add(r+":"+(c-1))){
            if (getChar(board, r, c-1) == word.charAt(index)) {
                if (helperF(board, r, c - 1, word, index + 1, con))
                    return true;
            }
            con.remove(r+":"+(c-1));
        }
        if (con.add(r+":"+(c+1))){
            if (getChar(board, r, c+1) == word.charAt(index)) {
                if (helperF(board, r, c + 1, word, index + 1, con))
                    return true;
            }
            con.remove(r+":"+(c+1));
        }
        return false;
    }

    private char getChar(char[][] board, int i, int c) {
        if (i < 0 || i >= board.length) return ' ';
        else if (c < 0 || c >= board[0].length) return ' ';
        return board[i][c];
    }

}
