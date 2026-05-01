class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        for(int i=1; i< leftProduct.length ; i++){
            leftProduct[i]=nums[i-1]*leftProduct[i-1];
        }
        int rightProduct = 1;
        for(int i=nums.length-1; i>=0; i--){
            int temp = nums[i];
            nums[i]=rightProduct * leftProduct[i];
            rightProduct = rightProduct * temp;
        }
        return nums;
    }
}  
