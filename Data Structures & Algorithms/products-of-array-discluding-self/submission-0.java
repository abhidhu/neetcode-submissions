class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroPosition = -1;
        int noOfTimeZero = 0;
        int productWithoutSum = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                if(++noOfTimeZero > 1){
                    break;
                }
                zeroPosition=i;
            }
            else{
                productWithoutSum = productWithoutSum * nums[i];
            }
            product = product * nums[i];
        }
        if(noOfTimeZero > 1){
            return new int[nums.length];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                nums[i] = productWithoutSum;
            }
            else{
                nums[i]=product/nums[i];
            }
        }
        return nums;
    }
}  
