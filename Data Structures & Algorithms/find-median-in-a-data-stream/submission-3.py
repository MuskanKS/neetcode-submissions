class MedianFinder:

    def __init__(self):
        self.maxheap = []     #store karenge lower half
        self.minheap = []      # isme karenge upper half

    def addNum(self, num: int) -> None:
        if not self.maxheap or num < -(self.maxheap[0]):
            heapq.heappush(self.maxheap, -num)
        else:
            heapq.heappush(self.minheap, num)

        # maxheap can be atmost 1 big then minheap
        if len(self.maxheap) > len(self.minheap) + 1:
            largest_lower = -(heapq.heappop(self.maxheap))
            heapq.heappush(self.minheap, largest_lower)
        elif len(self.minheap) > len(self.maxheap):
            smallest_upper = heapq.heappop(self.minheap)
            heapq.heappush(self.maxheap, -smallest_upper)

    def findMedian(self) -> float:
        if(len(self.maxheap) > len(self.minheap)):
            return -(self.maxheap[0])
        else:
            return (-(self.maxheap[0]) + self.minheap[0]) / 2
        