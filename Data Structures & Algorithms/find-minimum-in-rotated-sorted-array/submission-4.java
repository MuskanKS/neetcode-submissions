class Solution {
    public int findMin(int[] nums) {
        // brute
        Arrays.sort(nums);
        return nums[0];
    }
}
