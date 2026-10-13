class Solution {
    public boolean canJump(int[] nums) {
        int[] memo = new int[nums.length];
        return helper(nums, 0, memo);
    }
    private boolean helper(int[] nums, int idx, int[] memo){
        if(idx >= nums.length - 1){
            return true;
        }

        if(memo[idx] != 0){
            return memo[idx] == 1;
        }


        int far = Math.min(idx + nums[idx], nums.length - 1);
        for(int nxt = idx + 1; nxt <= far; nxt++){
            if(helper(nums, nxt, memo)){
                return true;
            }
        }
        memo[idx] = -1;
        return false;
    }
}
