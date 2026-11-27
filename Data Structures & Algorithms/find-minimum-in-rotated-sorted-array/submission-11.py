class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1
        ans = float("inf")

        while left <= right:
            mid = (left + right) // 2
            ans = min(ans, nums[mid])

            if left < right and nums[left] > nums[right]:
                if nums[mid] > nums[right]:
                    left = mid + 1
                else:
                    right = mid - 1
            else:
                if nums[mid] > nums[left]:
                    right = mid - 1
                else:
                    left = mid + 1

        return ans