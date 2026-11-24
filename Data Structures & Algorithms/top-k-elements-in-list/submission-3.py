class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # i will solve this using a min heap
        mh = []
        hm = {}

        for i in range(len(nums)):
            if nums[i] in hm:
                hm[nums[i]] = hm.get(nums[i], 0) + 1
            else:
                hm[nums[i]] = 1

        for num, value in hm.items():
            heapq.heappush(mh, (value, num))

        while len(mh) > k:
            heapq.heappop(mh)

        res = []
        while mh:
            value, num = heapq.heappop(mh)
            res.append(num)

        return res

