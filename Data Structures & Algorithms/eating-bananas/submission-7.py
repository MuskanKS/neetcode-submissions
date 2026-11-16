class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        right = max(piles)
        left = 1
        res = right

        while left <= right:
            speed = (right + left) // 2
            hours = 0
            for pile in piles:
                hours += (pile + speed - 1) // speed
            if hours > h:
                left = speed + 1
            else:
                res = speed
                right = speed - 1
        return res