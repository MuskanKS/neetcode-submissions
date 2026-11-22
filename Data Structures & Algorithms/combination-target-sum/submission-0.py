class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        self.res = []
        self.temp = []
        self.backtrack(nums, 0, target)
        return self.res

    def backtrack(self, nums, start, remaining):
        if remaining == 0:
            self.res.append(self.temp.copy())
            return 
        
        for i in range(start, len(nums)):
            if nums[i] > remaining:
                break
            self.temp.append(nums[i])
            self.backtrack(nums, i, remaining - nums[i])
            self.temp.pop()