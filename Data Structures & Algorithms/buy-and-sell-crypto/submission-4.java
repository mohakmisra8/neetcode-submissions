class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int left = 0;
        int right = 1;

        while(right < prices.length) {
            int tempProfit = 0;
            if(prices[right] > prices[left]) {
                tempProfit = prices[right] - prices[left];
                profit = Math.max(profit, tempProfit);
            } else{
                left = right;
            }
            right++;
        }
        
        return profit;
    }
}
