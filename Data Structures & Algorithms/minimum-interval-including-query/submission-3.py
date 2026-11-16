class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        intervals.sort()
        sortedQueries = sorted((query, i) for i, query in enumerate(queries))

        res = [-1] * len(queries)
        mh = []

        j = 0 #so that maine while loop se intervals from start scan kar pau har bar

        for query, originalIdx in sortedQueries:
            # means tab tak heap mei ghusa te rahe query mera intervals ke start se badi ya equal h 
            while j < len(intervals) and query >= intervals[j][0]:
                start = intervals[j][0]
                end = intervals[j][1]
                length = end - start + 1
                heapq.heappush(mh, (length, end))
                j += 1
            # ab hum end time ka check rakhenge agar mera end time jo hai wo agar,chota h query se to mai bas usko pop kar dungi heap se
            while mh and mh[0][1] < query:
                heapq.heappop(mh)
            
            if mh:
                res[originalIdx] = mh[0][0]
        
        return res
