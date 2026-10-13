
class Solution {
    public int jump(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return solve(nums, 0, memo);
    }

    private int solve(int[] nums, int index, int[] memo) {
        if (index >= nums.length - 1) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int minJumps = Integer.MAX_VALUE;
        int farthest = Math.min(index + nums[index], nums.length - 1);

        for (int next = index + 1; next <= farthest; next++) {
            int jumps = solve(nums, next, memo);

            if (jumps != Integer.MAX_VALUE) {
                minJumps = Math.min(minJumps, jumps + 1);
            }
        }

        memo[index] = minJumps;
        return minJumps;
    }
}