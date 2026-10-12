class Solution {
    public int[][] merge(int[][] intervals) {
        //  brute
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for(int[] curr : intervals){
            if(res.isEmpty() || curr[0] > res.get(res.size() - 1)[1]){
                res.add(curr);
            }else{
                int[] prev = res.get(res.size()-1);

                // prev[0] = Math.min(prev[0], curr[0]);

                prev[1] = Math.max(prev[1], curr[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
