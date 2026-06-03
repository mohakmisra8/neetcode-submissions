class Solution {
    public int maxProfit(int[] prices) {
        // initialise profit to 0 at the start
        // if profit < 0 return 0
        // start from left if value if right > left then sell
        // set diff between prices[right] - prices[left] as profit
        // return max between original and new
        int profit = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {
            int tempProfit = 0;
            if (prices[right] > prices[left]) {
                tempProfit = prices[right] - prices[left];
                profit = Math.max(tempProfit, profit);
            } else{
                left = right;
            }
            right++;
        }

        return profit;
        
    }
}
