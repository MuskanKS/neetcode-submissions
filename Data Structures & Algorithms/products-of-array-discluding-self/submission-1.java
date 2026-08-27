class Solution {
    public int[] productExceptSelf(int[] nums) {
        // create a prefix and postfix int[] where we will store the prod of the before numbers and initially declare a prod to be 1.

        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int prod = 1;
        // store prefix
        for(int i = 0; i < nums.length; i++){
            prefix[i] = prod;
            prod *= nums[i];
        }

        // store postfix for that intially declare prod to be 1 actually reset it to 1 
        prod = 1;
        for(int i = nums.length - 1; i >= 0; i--){
            postfix[i] = prod;
            prod *= nums[i];
        }

        // now initialize a res where we will declare the res and in that we will store the prod of the prefix and postfix of every index.
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = prefix[i] * postfix[i];
        }
        return res;
    }
}  
