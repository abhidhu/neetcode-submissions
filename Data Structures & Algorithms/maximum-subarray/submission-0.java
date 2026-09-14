class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int last = ans;
        for(int i=1; i<nums.length;i++){
            int temp = last + nums[i];
            if(temp>nums[i]){
                ans=Math.max(temp, ans);
                last=temp;
            }else{
                ans=Math.max(ans, nums[i]);
                last=nums[i];
            }
        }
        return ans;
    }
}
