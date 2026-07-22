class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        int prev=nums[0];
        int next =Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length;i++){
            int temp = next;
            next = Math.max(nums[i]+prev, next);
            prev=temp;
        }
        return next;
    }
}