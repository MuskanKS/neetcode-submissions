"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        # ye min heap se solve hoga uska size return kardo utna jaega aur utne rooms chahiye
        # we will create a min heap to store the end time
        mh = []
        intervals.sort(key=lambda interval:interval.start)

        for i in range(len(intervals)):
            startTime = intervals[i].start
            endTime = intervals[i].end

            if mh and mh[0] <= startTime:
                heapq.heappop(mh)
            heapq.heappush(mh, endTime)
        
        return len(mh)
            