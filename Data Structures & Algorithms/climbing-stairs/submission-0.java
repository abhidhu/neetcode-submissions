class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int[] num = new int[n+1];
        num[0]=1;
        num[1]=1;
        for(int i=2;i<n+1;i++){
           num[i]=num[i-1]+num[i-2];
        }
        return num[n];
    }
}