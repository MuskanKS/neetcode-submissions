class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        maxCount = 0

        hm = {}

        for i in range(len(nums)):
            if nums[i] not in hm:
                hm[nums[i]] = 1
            else:
                hm[nums[i]] = 1

        for i in range(len(nums)):
            if not (nums[i] - 1) in hm:
                curr = nums[i]
                count = 1
                while (curr + 1) in hm:
                    count += 1
                    curr = curr + 1
                maxCount = max(maxCount, count)
              

        return maxCount

