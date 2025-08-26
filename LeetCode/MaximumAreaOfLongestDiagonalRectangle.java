class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiagonalLength = 0;
        int maxArea = 0;
        for (int i = 0; i < dimensions.length; i++) {
            double diagonalLength = Math.sqrt(dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1]);
            if (maxDiagonalLength < diagonalLength) {
                maxArea = dimensions[i][0] * dimensions[i][1];
                maxDiagonalLength = diagonalLength;
            } else if (maxDiagonalLength == diagonalLength) {
                maxArea = Math.max(maxArea, dimensions[i][0] * dimensions[i][1]);
            }
        }
        return maxArea;
    }
}
