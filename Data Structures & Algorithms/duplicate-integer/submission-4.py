class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        hm = {}

        for i in range(len(nums)):
            if nums[i] in hm:
                return True
            else:
                hm[nums[i]] = i
        
        return False