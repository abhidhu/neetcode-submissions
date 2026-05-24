class Solution{
  public int maxProfit(int[] p){
    if(p==null || p.length < 2){
      return 0;
    }
    int max = 0;
    int left = 0;
    int right = left+1;
    while(right < p.length){
      if(p[left] < p[right]){
        max = Math.max(max, p[right]-p[left]);
      }else{
        left=right;
      }
      right++;
    }
    return max;
  }
}
