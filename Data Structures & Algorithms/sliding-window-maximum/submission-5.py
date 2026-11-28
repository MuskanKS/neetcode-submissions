class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        dq = deque()
        res = []

        for right in range(len(nums)):
            left = right - k + 1
            while dq and left > dq[0]:
                dq.popleft()

            while dq and nums[dq[-1]] < nums[right]:
                dq.pop()

            dq.append(right)

            if right >= k - 1:
                ans = nums[dq[0]]
                res.append(ans)

        return res