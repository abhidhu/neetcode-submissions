class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=1; i<=n; i++){
            ans[i]= ans[i>>>1] + helper(i&1);
        }
        return ans;
    }
    
    private int helper(int i){
        int ans =0;
        while(i != 0){
            if((i&1) == 1){
                ans++;
            }
            i=i>>>1;
        }
        return ans;
    }
}