class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        mh = []
        hm = {}

        for i in range(len(nums)):
            hm[nums[i]] = hm.get(nums[i], 0) + 1
        
        for num in hm:
            heapq.heappush(mh, (hm[num], num))
        

        while len(mh) > k:
            heapq.heappop(mh)
        
        res = []
        while mh:
            count, num = heapq.heappop(mh)
            res.append(num)
        return res