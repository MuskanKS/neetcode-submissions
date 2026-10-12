class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // brute
        List<int[]> ans = new ArrayList<>();

        for(int[] interval: intervals){
            ans.add(interval);
        }
        ans.add(newInterval);
        ans.sort((a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();

        for(int[] interval: ans){
            if(res.isEmpty() || res.get(res.size()-1)[1] < interval[0]){
                res.add(interval);
            }else{
                int[] last = res.get(res.size() - 1);
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
