class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices[0]
        mostProfit = 0

        for right in range(1, len(prices)):
            if prices[right] < buy:
                buy = prices[right]
            else:
                sell = prices[right] - buy
                mostProfit = max(mostProfit, sell)

        return mostProfit