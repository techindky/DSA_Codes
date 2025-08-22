import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1]; // r - c mapped by + (n-1)
        boolean[] diag2 = new boolean[2 * n - 1]; // r + c

        backtrack(0, n, board, cols, diag1, diag2, res);
        return res;
    }

    private void backtrack(int r, int n, char[][] board,
                           boolean[] cols, boolean[] d1, boolean[] d2,
                           List<List<String>> res) {
        if (r == n) {
            res.add(toList(board));
            return;
        }
        for (int c = 0; c < n; c++) {
            int id1 = r - c + (n - 1);
            int id2 = r + c;
            if (cols[c] || d1[id1] || d2[id2]) continue;

            cols[c] = d1[id1] = d2[id2] = true;
            board[r][c] = 'Q';

            backtrack(r + 1, n, board, cols, d1, d2, res);

            board[r][c] = '.';
            cols[c] = d1[id1] = d2[id2] = false;
        }
    }

    private List<String> toList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) list.add(new String(row));
        return list;
    }
}
