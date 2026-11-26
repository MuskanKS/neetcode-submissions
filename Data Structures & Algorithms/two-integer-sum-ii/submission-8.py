class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        # using two pointer as its sorted
        left = 0
        right = len(numbers) - 1

        while left < right:
            sum = numbers[left] + numbers[right]
            if target == sum:
                return [left + 1, right + 1]
            elif sum > target:
                right -= 1
            else:
                left += 1
        return [-1, -1]
