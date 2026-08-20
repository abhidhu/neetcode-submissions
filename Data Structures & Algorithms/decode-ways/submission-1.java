class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int n = s.length();
        int dp[] = new int[n+1];
        dp[0]=1;//base case wanted for dp
        for(int i=1; i<dp.length;i++){
            char c = s.charAt(i-1);
            if('1'<=c && c<='9'){
                dp[i]=dp[i-1];//single character is valid 
            }
            if(i-2>=0 ){
                char prev = s.charAt(i-2);
                if(prev=='1'){
                    dp[i]+=dp[i-2];
                }
                else if(prev=='2' && '0'<=c && c<='6'){
                    dp[i]+=dp[i-2];
                }else if(c=='0'){
                    return 0;//invalid
                }
            }
        }

        return dp[n];
    }
}
