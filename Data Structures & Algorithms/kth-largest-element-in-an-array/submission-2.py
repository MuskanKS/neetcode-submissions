class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        mh = []
        res = []

        for i in range(len(nums)):
            heapq.heappush(mh, nums[i])

        while len(mh) > k:
            heapq.heappop(mh)
        
        return heapq.heappop(mh)