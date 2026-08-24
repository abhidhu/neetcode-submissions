class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp =new int[m][n];
        dp[m-1][n-1]=1;//base case
        return helper(0, 0, dp, m, n);
    }

    private int helper(int i, int j, int[][] dp, int m, int n){
        if(i>=m || j>=n){
            return 0;//no way to move
        }
        if(dp[i][j] != 0) {
            return dp[i][j];
        }
        //calculate set and return
        //down
        int down = helper(i+1, j, dp, m, n);
        int right = helper(i, j+1, dp, m, n);
        dp[i][j] = down + right;
        return dp[i][j];
    }
}