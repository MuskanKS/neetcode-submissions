class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        mh = []

        for i in range(len(stones)):
            heapq.heappush(mh, -stones[i])
        

        while len(mh) > 1:
            heaviest = -(heapq.heappop(mh))
            secheavy = -(heapq.heappop(mh))

            if heaviest != secheavy:
                diff = heaviest - secheavy
                heapq.heappush(mh, -diff)
            
        return -(mh[0]) if mh else 0