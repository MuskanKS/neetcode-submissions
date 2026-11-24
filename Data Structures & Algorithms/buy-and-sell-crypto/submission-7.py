class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices[0]
        maxProfit = 0

        for i in range(1, len(prices)):
            if prices[i] < buy:
                buy = prices[i]
            else:
                sell = prices[i] - buy
                maxProfit = max(maxProfit, sell)

        return maxProfit