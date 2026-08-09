class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 0; i< prices.length;i++) {
            int tempProfit = prices[i] - minPrice;
            maxProfit = Math.max(tempProfit, maxProfit);

            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return maxProfit;
        
    }
}
