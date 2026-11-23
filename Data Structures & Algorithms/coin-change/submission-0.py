class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = [None] * (amount + 1)
        ans = self.dp(coins, amount, memo)

        if ans == float("inf"):
            return -1
        
        return ans

    def dp(self, coins, remaining, memo):
        if remaining == 0:
            return 0
        
        if memo[remaining] is not None:
            return memo[remaining]

        best = float("inf")

        for coin in coins:
            if coin <= remaining:
                coin_needed = 1 + self.dp(coins, remaining - coin, memo)
                best = min(best, coin_needed)

        memo[remaining] = best
        return memo[remaining]