class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int[] result = new int[rows * cols];
        if (mat == null || rows == 0) {
            return new int[0];
        }
        int k = 0;
        ArrayList<Integer> intermediate = new ArrayList<>();
        for (int i = 0; i < rows+cols-1; i++) {
            intermediate.clear();
            int r = i < cols ? 0 : i - cols + 1;
            int c = i < cols ? i : cols - 1;
            while (r < rows && c > -1) {
                intermediate.add(mat[r++][c--]);
            }
            if (i % 2 == 0) {
                Collections.reverse(intermediate);
            }
            for (int j = 0; j < intermediate.size(); j++) {
                result[k++] = intermediate.get(j);
            }
        }
        return result;
    }
}
