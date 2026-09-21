class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(h < piles.length){
            return 0;
        }
        int right = Integer.MIN_VALUE;
        for(int i : piles){
            right = Math.max(right, i);
        }

        int left = 1;
        //check until when we can eat banana 
        while(left < right){
            int mid = left + (right - left )/2;
            if(canEat(mid, piles, h)){
                right = mid;
            } else { 
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canEat(int n, int[] nums, int h){
        int total = 0;
        for(int i : nums){
            total =  total + i /n;
            if(i%n != 0){
                total++;
            }
        }
        return total <= h;
    }
}
