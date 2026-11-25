class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        hm = {}

        for i in range(len(numbers)):
            diff = target - numbers[i]
            if diff not in hm:
                hm[numbers[i]] = i
            else:
                return [hm.get(diff) + 1, i + 1]

        return [-1, -1]