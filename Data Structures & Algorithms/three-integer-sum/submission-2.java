class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < nums.length - 2 && nums[i] <=0; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;

            int diff = 0 - nums[i];

            while(left < right){
                int sum = nums[left] + nums[right];
                if(diff == sum){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
                else if(sum > diff){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
        
    }
}
