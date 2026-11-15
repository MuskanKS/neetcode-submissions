class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}

        for i in range(len(nums)):
            diff = target - nums[i]
            if diff in hm:
                return [hm.get(diff), i]
            hm[nums[i]] = i
        
        return [-1, -1]