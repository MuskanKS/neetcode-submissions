class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        hm = {}

        for i in range(len(nums)):
            if nums[i] in hm:
                return nums[i]
            hm[nums[i]] = hm.get(nums[i], 0) + 1

        return -1