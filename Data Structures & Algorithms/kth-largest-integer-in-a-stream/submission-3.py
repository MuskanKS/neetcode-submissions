class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.mh = []
        res = []
        for i in range(len(nums)):
            heapq.heappush(self.mh, nums[i])
            if len(self.mh) > k:
                heapq.heappop(self.mh)


    def add(self, val: int) -> int:
        heapq.heappush(self.mh, val)

        if len(self.mh) > self.k:
            heapq.heappop(self.mh)
        
        return self.mh[0]

        