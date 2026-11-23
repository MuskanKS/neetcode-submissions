class Solution:
    def rob(self, nums: List[int]) -> int:
        n = len(nums)
        memo = [-1] * (n)
        return self.dp(nums, 0, memo)

    def dp(self, nums, idx, memo):
        if idx >= len(nums):
            return 0

        if memo[idx] != -1:
            return memo[idx]

        skip = self.dp(nums, idx + 1, memo)

        rob = nums[idx] + self.dp(nums, idx + 2, memo)

        memo[idx] = max(skip, rob)
        return memo[idx]
        
        
    