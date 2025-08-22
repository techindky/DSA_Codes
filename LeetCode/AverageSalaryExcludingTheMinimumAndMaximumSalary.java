class Solution {
    public double average(int[] salary) {
        int max = 999, min = 1000001;
        double sum = 0;
        for (int i : salary) {
            sum += i;
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        sum -= (max + min);
        return sum / (salary.length - 2);
    }
}
