class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum =0;
        for(int i : nums){
            sum+=i;
        }
        if (Math.abs(target) > sum) return 0;

        int[][] dp = new int[nums.length][2*sum+1];
        for(int[] arr: dp){
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        return helper(0, 0, dp, nums, target, sum);
    }

    private int helper(int i, int total, int[][] dp, int[] nums, int target, int sum){
        if(i>nums.length){
            return 0;
        }
        if(i==nums.length){
            return total == target ? 1: 0;
        }
        int j = sum + total;
        if(dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }

        //we have 2 choise right 
        int pos = helper(i+1, total + nums[i], dp, nums,  target, sum);
        int neg = helper(i+1, total - nums[i], dp, nums, target, sum);
        return dp[i][j]=pos+neg;
    }

}