class Solution {
    public int maxProduct(int[] nums) {
        int prod=1;
        int ans=Integer.MIN_VALUE;
        for(int i=0; i<nums.length;i++){
            if(nums[i]==0){
                ans=Math.max(ans, 0);
                prod=1;
                continue;
            }
            else{
                prod=prod*nums[i];
                ans=Math.max(ans, prod);
            }
        }
        prod = 1;
        for(int i=nums.length-1; i>=0;i--){
            if(nums[i]==0){
                ans=Math.max(ans, 0);
                prod=1;
                continue;
            }
            else{
                prod=prod*nums[i];
                ans=Math.max(ans, prod);
            }
        }
        return ans;

    }
}
