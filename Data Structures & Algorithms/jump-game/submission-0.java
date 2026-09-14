class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0; i<nums.length; i++)   {
            max = Math.max(max, nums[i]+i);
            if(max==i || max>=nums.length){
                break;
            }
        }
        return max >= nums.length-1;
    }
}