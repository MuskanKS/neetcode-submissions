class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        startnew = newInterval[0]
        endnew = newInterval[1]
        idx = 0


        while idx < len(intervals) and startnew > intervals[idx][1]:
            res.append(intervals[idx])
            idx += 1
        
        while idx < len(intervals) and endnew >= intervals[idx][0]:
            startnew = min(startnew, intervals[idx][0])
            endnew = max(endnew, intervals[idx][1])
            idx += 1
        res.append([startnew, endnew])
        
        while idx < len(intervals):
            res.append(intervals[idx])
            idx += 1
        return res