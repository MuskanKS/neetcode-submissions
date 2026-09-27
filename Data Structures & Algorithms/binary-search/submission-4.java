class Solution {
    public int search(int[] nums, int target) {
        // optimal here we will check from both end and beginning if the target is less than or greater to according to that the high and low pointer will move left and right pointer

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            }else if(target > nums[mid]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
