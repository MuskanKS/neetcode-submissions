class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        hs = set()

        for i in range(len(nums)):
            hs.add(nums[i])

        maxCount = 0
        for i in range(len(nums)):
            if (nums[i] - 1) not in hs:
                curr = nums[i]
                count = 1
                while (curr + 1) in hs:
                    count += 1
                    curr = curr + 1
                maxCount = max(maxCount, count)

        return maxCount