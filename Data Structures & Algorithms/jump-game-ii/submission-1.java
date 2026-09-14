class Solution {
    public int jump(int[] nums) {
        int currentEnd = 0, jump = 0, max = 0;
        for(int i=0; i<nums.length; i++){
            max = Math.max(max, nums[i]+i);
            if(currentEnd==i && i<nums.length-1){
                jump++;
                currentEnd = max;
            }
           
        }
        return jump;
    }
}

