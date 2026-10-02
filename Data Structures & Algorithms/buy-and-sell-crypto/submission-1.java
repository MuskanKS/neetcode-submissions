class Solution {
    public int maxProfit(int[] prices) {
        // brute
        int buy = 0;
        int sell = 0;
        int max = 0;

        for(int i = 0; i < prices.length-1; i++){
            for(int j = i + 1; j < prices.length; j++){
                sell = prices[j] - prices[i];
                max = Math.max(max, sell);
               
            }
        }
        return max;
    }
}
