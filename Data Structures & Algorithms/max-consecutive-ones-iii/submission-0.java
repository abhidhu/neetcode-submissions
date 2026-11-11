class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = k;
        int left =0; int right = 0;
        int count = 0;
        while(right < nums.length ) { 
            if(nums[right]==1) {
                right++;
                ans = Math.max(ans, right -left);
                
                continue;
            }
            // we are here it means nums[i] is 0
            //option 1 lets flip it
            if(count < k) {
                count ++;
                right++;
                ans = Math.max(ans, right -left);
                continue;
            }
            // if we are here means nums[i] is 0 and we cant flip i to 1 so lets do left++

            if(nums[left] == 0) {
                count--;// reduce the count
                
            }
            left++;
        }
        return ans;
    }
}