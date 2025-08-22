class Solution {
    public String tictactoe(int[][] moves) {
        int n = moves.length;
        char[][] game = new char[3][3];
        if (n < 5) return "Pending";
        boolean x_turn = true;
        for (int i = 0; i < n; i++) {
            game[moves[i][0]][moves[i][1]] = x_turn ? 'X' : 'O';
            x_turn = !x_turn;
        }
        if ((game[0][0] == 'X' && game[0][1] == 'X' && game[0][2] == 'X') || 
            (game[1][0] == 'X' && game[1][1] == 'X' && game[1][2] == 'X') || 
            (game[2][0] == 'X' && game[2][1] == 'X' && game[2][2] == 'X') || 
            (game[0][0] == 'X' && game[1][0] == 'X' && game[2][0] == 'X') || 
            (game[0][1] == 'X' && game[1][1] == 'X' && game[2][1] == 'X') || 
            (game[0][2] == 'X' && game[1][2] == 'X' && game[2][2] == 'X') || 
            (game[0][0] == 'X' && game[1][1] == 'X' && game[2][2] == 'X') || 
            (game[2][0] == 'X' && game[1][1] == 'X' && game[0][2] == 'X')){
            return "A";
        }
        if ((game[0][0] == 'O' && game[0][1] == 'O' && game[0][2] == 'O') || 
            (game[1][0] == 'O' && game[1][1] == 'O' && game[1][2] == 'O') || 
            (game[2][0] == 'O' && game[2][1] == 'O' && game[2][2] == 'O') || 
            (game[0][0] == 'O' && game[1][0] == 'O' && game[2][0] == 'O') || 
            (game[0][1] == 'O' && game[1][1] == 'O' && game[2][1] == 'O') || 
            (game[0][2] == 'O' && game[1][2] == 'O' && game[2][2] == 'O') || 
            (game[0][0] == 'O' && game[1][1] == 'O' && game[2][2] == 'O') || 
            (game[2][0] == 'O' && game[1][1] == 'O' && game[0][2] == 'O')){
            return "B";
        }
        return n == 9 ? "Draw" : "Pending";
    }
}
