class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # lets solve this by using a hm
        hm = {}
        for num in nums:
            hm[num] = 1
        maxcount = 0
       
        
        for i in range(len(nums)):
            if (nums[i] - 1) not in hm:
                curr = nums[i]
                count = 1
                while (curr + 1) in hm:
                    count += 1
                    curr = curr+1
                maxcount = max(maxcount, count)

        return maxcount
        
