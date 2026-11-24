class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        # now we will solve this using optimize approach using a hashmap
        hm = {}
        # create empty hashmap
        for i in range(len(nums)):
            if nums[i] in hm:
                return True
            hm[nums[i]] = i
        
        return False