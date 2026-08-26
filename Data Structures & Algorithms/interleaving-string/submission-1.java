class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false;
        int[][] dp = new int[s1.length()+1][s2.length()+2];
        return helper(0, 0, 0, s1, s2, s3, dp);
    }

    private boolean helper(int i, int j, int k, String s1, String s2, String s3, int[][] dp){
        if(k==s3.length()){
            return true;
        }

        if(i< s1.length() && j< s2.length() && dp[i][j] != 0){
            return dp[i][j]==1 ? true :  false;
        }
        // while(k<s3.length()){
            char c1 = '\0';
            char c2 = '\0';
            char c3 = s3.charAt(k);//we have while loop for this condition
            if(i>=s1.length() && j>=s2.length()){
                return false;
            }
            if(i<s1.length()){
                c1=s1.charAt(i);
            }
            if(j<s2.length()){
                c2=s2.charAt(j);
            }
            boolean flag = false;

            if(c1==c2 && c1==c3){
                if (helper(i+1, j, k+1, s1, s2, s3, dp)) {
                    dp[i][j]=1;
                    return true;
                }
                flag =  helper(i, j+1, k+1, s1, s2, s3, dp);
                // dp[i][j]=flag ? 1 : 2;
                // return flag;
            }
            else if(c1==c3){
                // i++;
                flag = helper(i+1, j, k+1, s1, s2, s3, dp);
                // dp[i][j]=flag?1:0;
                // return flag;
            }else if (c2==c3){
                // j++;
                flag = helper(i, j+1, k+1, s1, s2, s3, dp);
                // dp[i][j]=flag?1:0;
                // return flag;
            }else{
                // flag = false;
                // dp[i][j]=2;
                // return false;
            }
            k++;
        // }
        dp[i][j]=flag ? 1 : 2;

        return  flag;

    }
}