class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        hm = {}

        for i in range(len(numbers)):
            diff = target - numbers[i]
            if diff in hm:
                return [hm[diff] + 1, i+1]
            hm[numbers[i]] = i
        
        return [-1, -1]