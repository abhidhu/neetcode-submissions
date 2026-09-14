class Solution {
    public int jump(int[] nums) {
        int currentEnd = 0, jump = 0, max = 0;
        for(int i=0; i<nums.length-1; i++){
            max = Math.max(max, nums[i]+i);
            if(currentEnd==i){
                jump++;
                currentEnd = max;
            }
        }
        // if(jump==0) return 1;
        return jump;
    }
}

