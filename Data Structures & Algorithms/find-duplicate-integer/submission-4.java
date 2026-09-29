class Solution {
    public int findDuplicate(int[] nums) {
        // optimal 
        int slow = nums[0];
        int fast = nums[0];

        // here it doesnt work like array its like ki u have to move and go to that idx the number it shows 

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        slow = nums[0];
        // moves 1-1 step until they become equal
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
