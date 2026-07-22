class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);
        return Math.max(robHelper1(nums), robHelper2(nums));
    }


    public int robHelper1(int[] nums) {
        int prev=nums[0];
        int next =Math.max(nums[0], nums[1]);
        for(int i=2; i<nums.length-1;i++){
            int temp = next;
            next = Math.max(nums[i]+prev, next);
            prev=temp;
        }
        return next;
    }
    public int robHelper2(int[] nums) {
        int prev=nums[1];
        int next =Math.max(nums[1], nums[2]);
        for(int i=3; i<nums.length;i++){
            int temp = next;
            next = Math.max(nums[i]+prev, next);
            prev=temp;
        }
        return next;
    }
}