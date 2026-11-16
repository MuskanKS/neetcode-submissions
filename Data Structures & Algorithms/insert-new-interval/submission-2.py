class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        idx = 0
        newStart = newInterval[0]
        newEnd = newInterval[1]

        # jo intervals new intervals ke pehle hai
        while idx < len(intervals) and newStart > intervals[idx][1]:
            res.append(intervals[idx])
            idx += 1
        
        while idx < len(intervals) and newEnd >= intervals[idx][0]:
            newStart = min(newStart, intervals[idx][0])
            newEnd = max(newEnd, intervals[idx][1])
            idx += 1
        res.append([newStart, newEnd])

        while idx < len(intervals):
            res.append(intervals[idx])
            idx += 1
        return res

