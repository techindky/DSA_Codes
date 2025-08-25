class Solution {
    // public void gameOfLife(int[][] board) {
    //     int n = board.length;
    //     int m = board[0].length;
    //     if (n * m == 1) {
    //         board[0][0] = 0;
    //         return;
    //     }
    //     int[][] temp = new int[n][m];
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             int lives = 0;
    //             if (j + 1 < m && board[i][j + 1] == 1)
    //                 lives++;
    //             if (j - 1 >= 0 && board[i][j - 1] == 1)
    //                 lives++;
    //             if (i + 1 < n && board[i + 1][j] == 1)
    //                 lives++;
    //             if (i - 1 >= 0 && board[i - 1][j] == 1)
    //                 lives++;
    //             if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1)
    //                 lives++;
    //             if (i + 1 < n && j + 1 < m && board[i + 1][j + 1] == 1)
    //                 lives++;
    //             if (i + 1 < n && j - 1 >= 0 && board[i + 1][j - 1] == 1)
    //                 lives++;
    //             if (i - 1 >= 0 && j + 1 < m && board[i - 1][j + 1] == 1)
    //                 lives++;
    //             if ((lives == 2 || lives == 3) && board[i][j] == 1)
    //                 temp[i][j] = 1;
    //             else if (lives == 3 && board[i][j] == 0)
    //                 temp[i][j] = 1;
    //         }
    //     }
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < m; j++) {
    //             board[i][j] = temp[i][j];
    //         }
    //     }
    // }

    // Approach 2 : Using Bit flags
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] di = {-1,-1,-1,0,0,1,1,1};
        int[] dj = {-1,0,1,-1,1,-1,0,1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    int ni = i + di[k], nj = j + dj[k];
                    if (0 <= ni && ni < m && 0 <= nj && nj < n && (board[ni][nj] & 1) == 1) {
                        live++;
                    }
                }
                int cell = board[i][j] & 1;
                if ((cell == 1 && (live == 2 || live == 3)) || (cell == 0 && live == 3)) {
                    board[i][j] |= 2; // set next-state bit
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}
