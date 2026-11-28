class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxProfit = 0
        buy = prices[0]

        for i in range(1, len(prices)):
            if buy > prices[i]:
                buy = prices[i]
            else:
                sell = prices[i] - buy
                maxProfit = max(maxProfit, sell)

        return maxProfit