class Solution {
    public int[] productExceptSelf(int[] nums) {
    //   optimal now instead of doing prefix and postfix i will do directly in the answer
    int[] res = new int[nums.length];
    // intialize product as 1 and then start filling in res for the prod.
    int prod = 1;
    for(int i = 0; i < nums.length; i++){
        res[i] = prod;
        prod *= nums[i];
    }

    // now we will reset the prod to not have any prior information and will start filling the res by multipling from backward.
    prod = 1;
    for(int i = nums.length - 1; i >= 0; i--){
        res[i] *= prod;
        prod *= nums[i];
    }
    return res;

    }
}  
