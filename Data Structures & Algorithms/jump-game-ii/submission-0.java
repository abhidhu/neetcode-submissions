class Solution {
    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        int max = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]+i);
            helper(dp, dp[i]+1, i+1, max);
        }
        return dp[dp.length-1];
    }

    private void helper(int[] dp, int count, int i, int j){
        while(i<dp.length && i<=j){
            dp[i]=Math.min(dp[i], count);
            i++;
        }
    }
}

