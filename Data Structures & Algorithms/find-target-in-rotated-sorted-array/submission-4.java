class Solution {
    public int search(int[] nums, int target) {
        // optimise
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target){
                return mid;
            }
            if(nums[left] <= nums[mid]){
                // means left - mid is sorrted then find target there
                if(nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }
                else{
                    left = mid + 1;
                }
            }
            // means the right half means from mid to right its sorted
            else{
                if(nums[right] >= target && nums[mid] < target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            

            }
        }
        return -1;
    }
}
