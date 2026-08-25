class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, dp, amount, coins, n);
    }

    private int helper(int i, int[][] dp, int remaining, int[] coins, int n){
        if(i>=n || remaining <0) return 0;
        if(remaining == 0) return 1;
        if(dp[i][remaining] != -1){
            return dp[i][remaining];
        }
       int count =0;
       if(remaining >=coins[i]){
           count = helper(i, dp,  remaining - coins[i], coins, n);
       }
       int skip = helper(i+1,dp,  remaining, coins, n);
        return dp[i][remaining]=count + skip;
    }
} 