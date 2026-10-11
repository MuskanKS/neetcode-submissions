class Solution {
    public int lastStoneWeight(int[] stones) {
        // brute
        List<Integer> res = new ArrayList<>();
        for(int stone : stones){
            res.add(stone);
        }
        while(res.size() > 1){
            Collections.sort(res);
            int y = res.remove(res.size() - 1); //largest
            int x = res.remove(res.size() - 1); //second largest

            if(x != y){
                res.add(y - x);
            }
        }
        return res.isEmpty() ? 0 : res.get(0);
    }
}
