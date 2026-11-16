class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maxProfit = 0

        for i in range(len(prices)):
            buy = prices[i]
            print(buy)
            for j in range(i + 1, len(prices)):
                sell = prices[j]
                profit = sell - buy
                maxProfit = max(maxProfit, profit)

        return maxProfit 
