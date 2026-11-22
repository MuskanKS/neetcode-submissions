class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        self.res = []
        self.temp = []
        self.backtrack(candidates, 0, target)

        return self.res

    def backtrack(self, nums, start, remaining):
        if remaining == 0:
            self.res.append(self.temp.copy())
            return
        
        for i in range(start, len(nums)):
            if remaining < nums[i]:
                break

            if i > start and nums[i] == nums[i-1]:
                continue

            
            self.temp.append(nums[i])
            self.backtrack(nums, i + 1, remaining - nums[i])
            self.temp.pop()