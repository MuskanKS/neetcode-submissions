class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            // means if end of one interval is less than start of new interval then we will have them in list before inserting our new interval
            res.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            // means if the start of our interval is less then or equal to the end of new interval then we will merge
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        // if that merge of and all done still if some are left just add them in the res
        while(i < intervals.length){
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
