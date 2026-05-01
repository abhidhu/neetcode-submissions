class Solution {
    public int[] productExceptSelf(int[] nums) {


        int left[] = new int[nums.length];
        int[] right = new int[nums.length];
        left[0]=1;
        right[nums.length-1]=1;
        for(int i=1;i<nums.length;i++){
            left[i]=left[i-1]*nums[i-1];
            right[nums.length-i-1]=nums[nums.length-i]*right[nums.length-i];
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=left[i]*right[i];
        }
        return nums;

        //But problem it self mentioned no devision operator so below ans is useless 
    //     int product = 1;
    //     int zeroPosition = -1;
    //     int noOfTimeZero = 0;
    //     int productWithoutSum = 1;
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i] == 0){
    //             if(++noOfTimeZero > 1){
    //                 break;
    //             }
    //             zeroPosition=i;
    //         }
    //         else{
    //             productWithoutSum = productWithoutSum * nums[i];
    //         }
    //         product = product * nums[i];
    //     }
    //     if(noOfTimeZero > 1){
    //         return new int[nums.length];
    //     }
    //     for(int i=0;i<nums.length;i++){
    //         if(nums[i] == 0){
    //             nums[i] = productWithoutSum;
    //         }
    //         else{
    //             nums[i]=product/nums[i];
    //         }
    //     }
    //     return nums;
    }
}  
