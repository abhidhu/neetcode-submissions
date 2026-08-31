class Solution {
    public int minDistance(String word1, String word2) {
        int[][]  dp = new int[word1.length()][word2.length()];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return helper(0, 0, dp, word1, word2);
    }

    private int helper(int i, int j, int[][] dp, String word1, String word2){
        if(i>=word1.length() && j>=word2.length()){
            return 0;
        }
        if(i>=word1.length()){
            return word2.length()-j;
        }
        if(j>=word2.length()){
            return word1.length()- i;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        //3 choices and 1 non
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j]=helper(i+1, j+1, dp, word1, word2);
        }else{
            int ans = helper(i+1, j, dp, word1, word2);//delete
            ans = Math.min(ans, helper(i+1, j+1, dp, word1, word2));//replace
            ans = Math.min(ans, helper(i, j+1, dp, word1, word2));//insert
            return dp[i][j]= 1+ ans;
        }
    }
}