class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int start = 0;
        while(start < s.length()){
            int end = s.lastIndexOf(s.charAt(start));
            for(int i = start; i <= end; i++){
                end = Math.max(end, s.lastIndexOf(s.charAt(i)));
            }
            res.add(end - start + 1);
            start = end + 1;
        }
        return res;
    }
}
