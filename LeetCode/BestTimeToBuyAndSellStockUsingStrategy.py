class Solution:
    def maxProfit(self, prices: List[int], strategy: List[int], k: int) -> int:
        n = len(prices)
        ip = sum(s * p for s,p in zip(strategy, prices))
        price_ps = [0] * (n+1)
        profit_ps = [0] * (n + 1)
        for i in range(n):
            price_ps[i+1] = price_ps[i] + prices[i]
            profit_ps[i+1] = profit_ps[i] + strategy[i] * prices[i]
        max_pc = 0
        for s in range(n - k + 1):
            end = s + k
            mid = s + (k // 2)
            new_profit = price_ps[end] - price_ps[mid]
            old_profit = profit_ps[end] - profit_ps[s]
            pc = new_profit - old_profit
            max_pc = max(max_pc, pc)
        return ip + max_pc
