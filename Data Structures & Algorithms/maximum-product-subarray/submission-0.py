class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        return self.dp(nums)
    def dp(self, nums):
        curr_max = nums[0]
        curr_min = nums[0]
        ans = nums[0]

        for i in range(1, len(nums)):
            if nums[i] < 0:
                curr_max, curr_min = curr_min, curr_max

            curr_max = max(nums[i], curr_max * nums[i])
            curr_min = min(nums[i], curr_min * nums[i])
            ans = max(ans, curr_max)

        return ans
        