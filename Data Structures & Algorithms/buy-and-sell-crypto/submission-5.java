class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        int right = 1;

        while (right < prices.length) {
            int tempProfit = 0;
            // choose smallest price and largest price
            if(prices[left] < prices[right]) {
                tempProfit = prices[right] - prices[left];
                profit = Math.max(tempProfit, profit);
            } else {
                left = right;
            }
            right++;
        }
        
        return profit;
    }
}
