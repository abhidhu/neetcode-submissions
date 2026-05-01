class Solution {
    public int maxProfit(int[] p) {
        int ans=0;
        int i=0;
        int j= i+1;
        while(j<p.length){
            if(p[i]>p[j]){
                i=j;
                j=i+1;
            } else{
                ans = Math.max(ans, p[j]-p[i]);
                j++;
            }
        }
        return ans;
    }
}
