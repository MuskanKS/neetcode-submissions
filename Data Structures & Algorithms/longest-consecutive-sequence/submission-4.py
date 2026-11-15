class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # if i want to find longest consequitive sequence i will use a hs
        hs = set(nums)
        maxCount = 0

        for num in hs:
            if num - 1 not in hs:
                curr = num
                count = 1

                while curr + 1 in hs:
                    curr += 1
                    count += 1

                maxCount = max(maxCount, count)
        
        return maxCount