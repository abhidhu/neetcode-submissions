class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        return helper(0, 0, 0, s1, s2, s3, dp)==1;
    }

    private int helper(int i, int j, int k, String s1, String s2, String s3, int[][] dp){


        if(i<s1.length() && j<s2.length() && dp[i][j] != 0){
            return dp[i][j];
        }
        if(i>=s1.length() && j>=s2.length()){
            return 1;
        }
        char c1 = '\0';
        char c2 = '\0';
        char c3 = '\0';

        if(i<s1.length()){
            c1=s1.charAt(i);
        }
        if(j<s2.length()){
            c2=s2.charAt(j);
        }
        if(k<s3.length()){
            c3=s3.charAt(k);
        }
        
        boolean flag = false;

        if(c1==c2){
            flag= c1==c3 && (helper(i+1, j, k+1, s1, s2, s3, dp)==1 || helper(i, j+1, k+1, s1, s2, s3, dp)==1);
        }else if(c1==c3){
            flag=helper(i+1, j, k+1, s1, s2, s3, dp)==1;
        }else if(c2==c3){
            flag =helper(i, j+1, k+1, s1, s2, s3, dp)==1;
        }
        return dp[i][j]=flag ? 1 : 2;

    }
}