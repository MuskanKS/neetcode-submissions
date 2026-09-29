class Solution {
    public int findDuplicate(int[] nums) {
        // brute just use two loops to find
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    return nums[j];
                }
            }
        }
        return -1;
    }
}
