class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxProfit = 0
        initialStock = prices[0]
        for i in range(1,len(prices)):
            if initialStock>prices[i]:
                initialStock = prices[i]
            diff = prices[i]-initialStock
            if maxProfit<diff:
                maxProfit = diff
        return maxProfit
        
