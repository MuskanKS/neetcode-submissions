class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        startnew = newInterval[0]
        endnew = newInterval[1]
        idx = 0


        while idx < len(intervals) and startnew > intervals[idx][1]:
            idx += 1

        j = idx
        while j < len(intervals) and endnew >= intervals[j][0]:
            startnew = min(startnew, intervals[j][0])
            endnew = max(endnew, intervals[j][1])
            j += 1

        intervals[idx :j] = [[startnew, endnew]]

        return intervals