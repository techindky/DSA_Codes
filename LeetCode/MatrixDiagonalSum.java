class Solution {
    public int diagonalSum(int[][] mat) {
        int first_diagonal_sum = 0;
        int second_diagonal_sum = 0;
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            first_diagonal_sum += mat[i][i];
            if (i != (n-i-1)) second_diagonal_sum += mat[n-i-1][i];
        }
        return first_diagonal_sum + second_diagonal_sum;
    }
}
