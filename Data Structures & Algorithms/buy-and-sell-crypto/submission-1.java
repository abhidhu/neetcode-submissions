class Solution {
    public int maxProfit(int[] p) {
        int ans=0;
        int i=0;
        int j= i+1;
        int temp=0;
        while(j<p.length){
            if(p[i]>p[j]){
                i=j;
                j=i+1;
                temp=0;
                continue;
            }
            if(p[i]<p[j]){
                temp=p[j]-p[i];
            }
            if(temp>ans){
                ans=temp;
            }
            j++;
        }
        return ans;
    }
}
