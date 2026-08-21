class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        return helper(amount, coins, dp);
    }

    private int helper(int amount, int[] coins, int[] dp){
        if(amount==0) return 0;
        if(amount <0) return -1;
        if(dp[amount] !=0 ) return dp[amount];

        for(int i=0; i< coins.length; i++){
            int coin = coins[i];
            int res = helper(amount-coin, coins, dp);
            if(res != -1){
                dp[amount] = dp[amount] == 0  ? res+1 : Math.min(res+1, dp[amount]);
            }
        }
        if(dp[amount]==0) {
            return dp[amount]=-1;
        }
        return dp[amount];
    }
}