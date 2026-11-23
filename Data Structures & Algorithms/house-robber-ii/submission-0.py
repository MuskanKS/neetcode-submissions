class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        skip_first = self.rob_linear(nums[1:])

        skip_last = self.rob_linear(nums[:-1])
        return max(skip_first, skip_last)

    def rob_linear(self, houses):
        memo = [-1] * len(houses)
        return self.dp(houses, 0, memo)

    def dp(self, houses, idx, memo):
        if idx >= len(houses):
            return 0

        if memo[idx] != -1:
            return memo[idx]

        skip = self.dp(houses, idx + 1, memo)
        rob = houses[idx] + self.dp(houses, idx + 2, memo)

        memo[idx] = max(skip, rob)
        return memo[idx]