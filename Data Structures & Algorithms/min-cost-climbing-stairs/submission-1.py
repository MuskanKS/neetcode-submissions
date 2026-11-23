class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        n = len(cost)
        memo = [-1] * n
        return min(self.dp(cost, 0, memo), self.dp(cost, 1, memo))

    def dp(self, cost, i, memo):
        n = len(cost)
        if i >= n:
            return 0
        
        if memo[i] != -1:
            return memo[i]

        one_step = self.dp(cost, i + 1, memo)
        two_step = self.dp(cost, i + 2, memo)

        memo[i] = cost[i] + min(one_step, two_step)
        return memo[i]

        