class Solution {
    public int search(int[] nums, int target) {
       int left=0, right=nums.length-1;
       while(left<=right){
         int mid = left + (right-left)/2;
         if(nums[mid]==target) return mid;

         //check does left side is sorted 
         if(nums[left]<=nums[mid]){
            //we have 2 scenarios target is in sorted array or other
            if(nums[left] <= target && target < nums[mid]){
                //go to the left side
                right=mid-1;
            }else{
                left=mid+1;
            }
            // continue; no need to add continue as our if else block will do the work 
         }
         else{
            //means right side is sorted 100%
            if(nums[mid]<target && target <=nums[right]){
                //go to the right side 
                left = mid+1;
            }else{
                right=mid-1;
            }
         }
       }
       return -1;
    }
}