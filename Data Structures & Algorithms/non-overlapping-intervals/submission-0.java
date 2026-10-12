class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // optimse
        // we will sort first
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int remove = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int[] curr = intervals[i];
            if(curr[0] < prevEnd){
                remove++;
                prevEnd = Math.min(prevEnd, curr[1]);
            }else{
                prevEnd = curr[1];
            }

        }
        return remove;
    }
}
