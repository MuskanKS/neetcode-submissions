class Solution:
    def climbStairs(self, n: int) -> int:
        # backtracking se pehle ek memo ata hai
        memo = [-1] * (n + 1)
        return self.dp(n, memo)

    def dp(self, remaining, memo):
        if remaining == 0:
            return 1

        if remaining < 0:
            return 0
        
        if memo[remaining] != -1:
            return memo[remaining]
        count = 0 
        for step in(1, 2):
            count += self.dp(remaining-step, memo)
        memo[remaining] = count
        return memo[remaining]
        

