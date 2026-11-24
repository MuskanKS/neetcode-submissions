class Solution:
    def trap(self, height: List[int]) -> int:
        waterTrapped = 0
        left = 0
        right = len(height) - 1
        maxLeft = 0
        maxRight = 0

        while left < right:
            maxLeft = max(maxLeft, height[left])
            maxRight = max(maxRight, height[right])

            if(left < right and height[left] <= height[right]):
                waterTrapped += maxLeft - height[left]
                left += 1
            if(left < right and height[right] < height[left]):
                waterTrapped += maxRight - height[right]
                right -= 1
        return waterTrapped