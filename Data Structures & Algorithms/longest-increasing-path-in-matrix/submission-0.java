class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
         for (int[] row : dp) Arrays.fill(row, -1);
        int ans = 0;
        for(int i=0; i<matrix.length;i++){
            for(int j=0; j<matrix[i].length; j++){
                ans = Math.max(ans, helper(matrix, dp, Integer.MIN_VALUE, i, j));
            }
        }
        return ans;
    }

    private int helper(int[][] matrix, int[][] dp, int last, int i, int j){
        if(i<0 || j< 0 || i>= matrix.length || j>=matrix[i].length){
            return 0;
        }


        if(matrix[i][j]<=last){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = 0;
        //go 4 way and recird  ans
        ans = Math.max(ans, helper(matrix, dp, matrix[i][j], i+1, j));
        ans = Math.max(ans, helper(matrix, dp, matrix[i][j], i-1, j));
        ans = Math.max(ans, helper(matrix, dp, matrix[i][j], i, j+1));
        ans = Math.max(ans, helper(matrix, dp, matrix[i][j], i, j-1));
        return dp[i][j]=1+ans;
    }
}