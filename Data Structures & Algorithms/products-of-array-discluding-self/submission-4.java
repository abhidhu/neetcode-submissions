class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        left[0]=1;
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }
        int product =1;//product of right array
        for(int j=nums.length-1; j>=0; j--){
            int temp = nums[j];
            nums[j]=left[j]*product;
            product = product * temp;
        }
        return nums;
    }
}  
