class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int dp[][] =new int[m+1][n+1];//it can give us value 0 default and no need to check array bound
        for(int i=m-1; i>=0;i--){
            for(int j=n-1; j>=0; j--){
                dp[i][j]= text1.charAt(i)==text2.charAt(j) ? 1+dp[i+1][j+1] : Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}
