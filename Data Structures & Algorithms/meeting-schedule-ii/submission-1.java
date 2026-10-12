/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()){
            return 0;
        }

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Interval curr : intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= curr.start){
                minHeap.poll();
            }
            minHeap.add(curr.end);
        }
        return minHeap.size();
    }
}
