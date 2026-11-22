class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.temp = []
        self.backtrack(nums, 0)
        return self.res
        
    def backtrack(self, nums, start) -> List[List[int]]:
        self.res.append(self.temp.copy())

        for i in range(start, len(nums)):
            self.temp.append(nums[i])
            self.backtrack(nums, i + 1)
            self.temp.pop()