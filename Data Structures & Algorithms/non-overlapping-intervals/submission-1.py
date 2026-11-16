class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda interval:interval[1])
        prevEnd = intervals[0][1]
        count = 0

        for i in range(1, len(intervals)):
            start = intervals[i][0]
            end = intervals[i][1]

            if start >= prevEnd:
                prevEnd = end
            else:
                count += 1

        return count

