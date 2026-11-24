class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # lets solve this by using a hm
        hs = set(nums)
        maxcount = 0
       
        
        for i in range(len(nums)):
            if (nums[i] - 1) not in hs:
                curr = nums[i]
                count = 1
                while (curr + 1) in hs:
                    
                    count += 1
                    curr = curr+1
                maxcount = max(maxcount, count)

        return maxcount
        
