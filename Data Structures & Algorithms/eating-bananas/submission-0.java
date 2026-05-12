class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int right = Integer.MIN_VALUE;
        for(int i=0; i<piles.length;i++){
            right = Math.max(right, piles[i]);
        }
        int left = 1;
        int ans = Integer.MAX_VALUE;
        while(left <= right){
            int h1 = 0;
            int mid = (left+right)/2;
            for(int i=0; i<piles.length;i++){
                h1+=piles[i]/mid;
                if(piles[i]%mid != 0){
                    h1++;
                }
            }
            if(h1<=h){
                ans = Math.min(ans, mid);
                right = mid -1;
            }else{
                left = mid+1;
            }
            
        }
        return ans;
    }
}

