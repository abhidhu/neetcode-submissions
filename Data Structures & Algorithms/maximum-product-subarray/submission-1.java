class Solution {
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++) { 
            int val = nums[i];
            if(val != 0){
                left = left * val;
                 ans = Math.max(ans, left);
            }else{
                ans = Math.max(ans, 0);
                left = 1;
            }
            val = nums[nums.length - i-1];
            if(val != 0){
                right = right * val;
                ans = Math.max(ans, right);
            }else{
                ans = Math.max(ans, 0);
                right = 1;
            }
        }
        return ans;
    }
}