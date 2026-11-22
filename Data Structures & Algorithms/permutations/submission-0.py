class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        self.res = []
        self.temp = []
        self.used = set()
        self.backtrack(nums)

        return self.res

    def backtrack(self, nums):
        if len(self.temp) == len(nums):
            self.res.append(self.temp.copy())
    # base case ki agar len(temp) == len(nums)to res mei us temp ko dal 
         
        for i in range(len(nums)):
            if nums[i] in self.used:
                continue
                #  wo logic kaise likhu agar clreafy hai to continue
               
            
            self.temp.append(nums[i])
            self.used.add(nums[i])
            self.backtrack(nums)
            self.temp.pop()
            self.used.remove(nums[i])