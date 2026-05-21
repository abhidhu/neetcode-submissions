class Solution {
    public int findDuplicate(int[] nums) {
    
    if(nums == null || nums.length == 1){
        return -1;
    }
    int slow = 0;
    int fast = 0;
    //find the the cycle
    while(fast < nums.length){
       slow = nums[slow];
       fast = nums[nums[fast]];
       if(slow == fast){
        break;
       }
    }
    //find the start of loop
    int curr = 0;
    while(curr != slow){
        curr = nums[curr];
        slow = nums[slow];
    }
    return curr;
    }
}