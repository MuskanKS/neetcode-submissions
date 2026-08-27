class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            hs.add(nums[i]);
        }

        int longSeq = 1;
        for(int num : hs){
            if(hs.contains(num - 1)){
                continue;
            }else{
                int curr = num;
                int currSeq = 1;

                while(hs.contains(curr + 1)){
                    curr++;
                    currSeq++;
                }
                longSeq = Math.max(longSeq, currSeq);

            }
        }
        return longSeq;
    }
}
