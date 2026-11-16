class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        left = 0
        maxProfit = 0

        for right in range(1, len(prices)):
            buy = prices[left]
            if prices[right] < buy:
                left = right
            else:
                sell = prices[right]
                profit = sell - buy
                maxProfit = max(maxProfit, profit)
        return maxProfit