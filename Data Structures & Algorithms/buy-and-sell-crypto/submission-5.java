class Solution {
    public int maxProfit(int[] prices) {
        int[] arr = new int[prices.length];
        int max = 0;
        for(int i=prices.length-1; i>=0; i--){
          arr[i]=max;
          max = Math.max(max, prices[i]);
        }
        int ans = 0;
        for(int i=0; i<prices.length; i++){
          ans = Math.max(ans, arr[i]-prices[i]);
        }
        return ans;
    }
}
