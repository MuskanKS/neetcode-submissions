class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        minArray = float("inf")

        while left <= right:
            mid = (right + left) // 2
            minArray = min(minArray, nums[mid])
            if nums[left] <= nums[right]:     #means look in the left side
                if nums[left] < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            else:
                if nums[mid] < nums[right]:
                    right = mid - 1
                else:
                    left = mid + 1
        return minArray
