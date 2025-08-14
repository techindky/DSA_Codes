class Solution {
    public char[][] solveSudoku(char[][] board) {
        solve(board);
        return board;
    }

    private boolean solve(char[][] board) {
        int N = board.length;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board))
                                return true;
                            board[row][col] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        int N = board.length;
      
        for (int i = 0; i < N; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;
        }

        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int i = boxRowStart; i < boxRowStart + 3; i++) {
            for (int j = boxColStart; j < boxColStart + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }
}
