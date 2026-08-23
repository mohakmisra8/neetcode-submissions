class Solution {
    // dp problem with dfs: cheapest way to paint a house i a given colour depends only
    // on the cheapest ways to paint house i-1 in the other two colours
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        // dp[i][c] = min total cost to pain houses 0..i with house i in color c
        int[][] dp = new int[n][3];

        dp[0] = costs[0].clone(); // base case: first house costs its own price

        for (int i = 1; i < n; i++) {
            // for each colour, add the cheaper of the two to the allowes previous colours
            dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]); // red
            dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]); // blue
            dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]); // green
        }

        // cheaper colur for the last house
        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }
}