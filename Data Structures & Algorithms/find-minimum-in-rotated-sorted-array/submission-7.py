class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = float("inf")
        for i in range(len(nums)):
            res = min(res, nums[i])
        return res