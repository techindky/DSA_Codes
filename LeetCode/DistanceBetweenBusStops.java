class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int d1 = 0, d2 = 0, n = distance.length;
        for (int i = start; i < destination; i++) {
            d1 += distance[i];
        }
        for (int i = destination; i < n + start; i++) {
            d2 += distance[i % n];
        }
        return Math.min(d1,d2);
    }
}
