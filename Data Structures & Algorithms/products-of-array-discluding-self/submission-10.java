class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        if(nums.length <=1){
            return ans;
        }
        ans[0]=1;
        for(int i=1; i<nums.length;i++){
            ans[i]=ans[i-1]*nums[i-1]; // 1,1,2,6
        }
        int rightProduct = 1;
        for(int i=ans.length-1; i>=0;i--){
            ans[i]=rightProduct*ans[i];
            rightProduct*=nums[i];
        }
        return ans;
    }
}