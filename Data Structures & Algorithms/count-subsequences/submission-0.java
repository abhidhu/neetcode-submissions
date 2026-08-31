class Solution {
    public int numDistinct(String s, String t) {
        if(s.length() < t.length()) return 0;

        int[][] dp = new int[s.length()][t.length()];

        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, 0, dp, s, t);
    }

    private int helper(int i, int j, int[][] dp, String s, String t){
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        char c1 = s.charAt(i);
        char c2 = t.charAt(j);
        if(c1==c2){
            dp[i][j]=helper(i+1, j+1, dp, s, t) + helper(i+1, j, dp, s, t);
        }
        else{
            dp[i][j]=helper(i+1, j, dp, s, t);
        }
        return dp[i][j];
    }
}