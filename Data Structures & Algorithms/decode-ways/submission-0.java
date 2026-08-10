class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2; i<s.length()+1; i++){
            char c = s.charAt(i-1);
            if('0'<c && c<='9'){
                dp[i]=dp[i-1];
            }
            char prev = s.charAt(i-2);
            if(prev == '1'){
                dp[i]+=dp[i-2];
            }else if(prev == '2' && '0' <= c && c <= '6'){
                dp[i]+=dp[i-2];
            }
        }
        return dp[s.length()];
    }
}