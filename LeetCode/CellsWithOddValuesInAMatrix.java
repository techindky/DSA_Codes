class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        for (int[] i : indices) {
            rows[i[0]]++;
            cols[i[1]]++;
        }
        int r = 0, c = 0;
        for (int i : rows) {
            r += i % 2;
        }
        for (int i : cols) {
            c += i % 2;
        }
        return r * n + c * m - 2 * r * c;
    }
}
