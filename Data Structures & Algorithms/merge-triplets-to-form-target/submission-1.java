class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[3];

        for(int[] num: triplets){
            if(num[0] > target[0] || num[1] > target[1] || num[2] > target[2]){
                continue;
            }
            res[0] = Math.max(res[0], num[0]);
            res[1] = Math.max(res[1], num[1]);
            res[2] = Math.max(res[2], num[2]);
        }
        return res[0] == target[0] && res[1] == target[1] && res[2] == target[2];
    }
}
