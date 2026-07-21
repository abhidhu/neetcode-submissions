class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int i=1;
        int j=1;
        int ans=0;
        for(int k=2;k<n+1;k++){
           ans=i+j;
           i=j;
           j=ans;
        }
        return ans;
    }
}