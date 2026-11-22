class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        self.res = []
        self.temp = []
        self.backtrack(nums, 0)

        return self.res

    def backtrack(self, nums, start):
        self.res.append(self.temp.copy())

        for i in range(start, len(nums)):
            if i > start and nums[i] == nums[i-1]:
                continue
            
            self.temp.append(nums[i])
            self.backtrack(nums, i +1)
            self.temp.pop()
        