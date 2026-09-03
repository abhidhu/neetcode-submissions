class Solution {
    public int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, nums.length-1, 1, 1, nums, dp);
    }

    private int helper(int i, int j, int left, int right, int[] nums, int[][] dp){
        if(j<i || i<0 || j<0 || i>=nums.length || j>=nums.length){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        for(int k=i; k<=j; k++){ 
            int temp = left * right * nums[k];
            temp+=helper(i, k-1, left, nums[k], nums, dp);
            temp+=helper(k+1, j, nums[k], right, nums, dp);
            ans = Math.max(temp, ans);
        }

        return dp[i][j]=ans;
    }
}