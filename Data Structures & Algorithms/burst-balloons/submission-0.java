class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return helper(0, n-1, 1, 1, n, dp, nums);
    }

    private int helper(int i, int j, int left, int right, int n, int[][] dp, int[] nums){
        if(j<i || i<0 || j>= n){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans =0;
        for(int k=i; k<=j; k++){
            int temp = left * nums[k] * right + helper(k+1, j, nums[k], right, n, dp, nums) 
                     + helper(i, k-1, left, nums[k], n, dp, nums); 
            
            ans = Math.max(ans, temp);
        }
        return dp[i][j]=ans;
    }
}