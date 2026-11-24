class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        mh = []

        for x, y in points:
            dis = x*x + y*y
            heapq.heappush(mh, (-dis, x, y))
            if len(mh) > k:
                heapq.heappop(mh)

        res = []
        while mh:
            dist, x, y = heapq.heappop(mh)
            res.append((x, y))

        return res