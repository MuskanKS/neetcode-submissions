"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:
        intervals.sort(key=lambda interval:interval.start)
        
        if not intervals:
            return True
            
        count = len(intervals)
        st1 = intervals[0].start
        et1 = intervals[0].end

        for i in range(1, len(intervals)):
            nst = intervals[i].start
            net = intervals[i].end
            if et1 > nst:
                count -= 1
            else:
                st1 = nst
                et1 = net
            
        return count == len(intervals)