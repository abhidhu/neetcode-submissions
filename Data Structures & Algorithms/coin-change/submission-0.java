class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //mark all subproblems as unvisited (-2)
        Arrays.fill(dp, -2);
        return helper(amount, dp, coins);
    }

    private int helper(int rem, int[] dp, int[] coins){
      if(rem<0) return -1;
      if(rem==0) return 0;
      //return cached result if already computed
      if(dp[rem] != -2) return dp[rem];

      int minCoins = Integer.MAX_VALUE;

      for(int coin: coins){
        int subResult = helper(rem-coin, dp, coins);

        //if subproblem has valid result
        if(subResult != -1) {
            minCoins = Math.min(minCoins, subResult + 1);
        }
      }
      dp[rem] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
      return dp[rem];
    }
}