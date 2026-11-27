class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        right = max(piles)
        ans = right
        left = 1

        while left <= right:
            hours = 0
            speed = (left + right) // 2
            for pile in piles:
                hours += (pile + speed - 1) // speed
            if hours <= h:
                ans = speed
                right = speed - 1
            else:
                left = speed + 1

        return ans