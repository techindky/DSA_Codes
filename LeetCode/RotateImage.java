class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        for (int i = 0; i < n / 2; i++) {
            for (int j = left; j < right; j++) {
                int temp = matrix[top][j];
                matrix[top][j] = matrix[bottom-j+left][left];
                matrix[bottom-j+left][left] = matrix[bottom][right-j+left];
                matrix[bottom][right-j+left] = matrix[top+j-left][right];
                matrix[top+j-left][right] = temp;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }
}
