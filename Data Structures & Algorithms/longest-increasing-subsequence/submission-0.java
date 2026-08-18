class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans =0;
        for(int i=n-1; i>=0; i--){
            dp[i]=helper(nums[i], i+1, dp, nums, n);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private int helper(int val, int i, int[] dp, int[] nums, int n){
        int ans = 1;
        while(i<n){
            if(val<nums[i]){
                ans=Math.max(ans, 1+dp[i]);
            }
            i++;
        }
        return ans;
    }
}