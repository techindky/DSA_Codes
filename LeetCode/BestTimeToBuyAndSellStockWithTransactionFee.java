class Solution {
    public int maxProfit(int[] prices, int fee) {
        int hold = 0 - prices[0];
        int cash = 0;

        for (int i = 1; i < prices.length; i++) {
            // Calculate next states based on previous ones
            int newHold = Math.max(hold, cash - prices[i]);
            int newCash = Math.max(cash, hold + prices[i] - fee);
            hold = newHold;
            cash = newCash;
        }
        return cash;
    }
}
