class Solution {
    public int maxProfit(int[] prices) {
        // set 2 variables minPrice and maxProfit
        // compute profit via prices[i] - minPrice
        // update minPrice if today's price is lower
        // profit on  days when price is higher than minmum not lower
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int tempProfit = prices[i] - minPrice;
            maxProfit = Math.max(tempProfit, maxProfit);

            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

        }

        return maxProfit;
    }
}
