class Solution {
    public int maxProfit(int[] prices) {
        // better
        int[] maxRight = new int[prices.length];
        maxRight[prices.length - 1] = prices[prices.length - 1];

        for(int i = prices.length - 2; i >= 0; i--){
            maxRight[i] = Math.max(prices[i + 1], maxRight[i + 1]);
            System.out.println(Arrays.toString(prices));
System.out.println(Arrays.toString(maxRight));
            
        }
        

        int maxProfit = 0;

        for(int i = 0; i < prices.length-1; i++){
            int profit = maxRight[i] - prices[i];
            maxProfit = Math.max(maxProfit, profit);
               
        }
        return maxProfit;
    }
}
