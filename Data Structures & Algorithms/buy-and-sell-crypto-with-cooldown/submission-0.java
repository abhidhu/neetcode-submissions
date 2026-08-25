class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, dp, prices, false, n);

    }

    private int helper(int i, int[][] dp, int[] prices, boolean flag, int n){
        
        if(i>=n){
            return 0;
        }

        int j = flag ? 1 : 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int result;

        if(flag){
            int sell = prices[i] + helper(i+2, dp, prices, false, n);
            int hold = helper(i+1, dp, prices, true, n);
            result = Math.max(sell, hold);
        }else{
            int buy = -prices[i] + helper(i+1, dp, prices, true, n);
            int skip = helper(i+1, dp, prices, false, n);
            result = Math.max(buy, skip);
        }
        return dp[i][j]=result;
    }
}