class Solution {
    public int maxSubArray(int[] nums) {
        // optimise here we will just see if our sum becomes < 0 then we will start from new subarray
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int num : nums){
            sum += num;
            maxSum = Math.max(maxSum, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }
}
