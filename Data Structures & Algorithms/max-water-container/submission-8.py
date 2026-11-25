class Solution:
    def maxArea(self, heights: List[int]) -> int:
        mostWater = 0
        left = 0
        right = len(heights) - 1

        while left < right:
            # here also left and right cant be equal because we have to compare water store between two heights of bar
            height = min(heights[left], heights[right])
            width = right - left
            area = height * width
            mostWater = max(mostWater, area)

            # check kaunsa chota hai not while if hoga kyuki continuous skip thodi karna h isko 
            if heights[left] <= heights[right]:
                left += 1
            else:
                right -= 1

        return mostWater