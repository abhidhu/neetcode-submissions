class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[1 + nums.length - k];
        int left = 0;
        for(int right=0; right<nums.length; right++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right] ){
                dq.pollLast();
            }
            dq.offerLast(right);
            if(right >= k-1){
                ans[left]=nums[dq.peekFirst()];
                if(dq.peekFirst()==left){
                    dq.pollFirst();
                }
                left++;
            }
        }
        return ans;
    }
}
//[1,3,-1,-3,5,3,6,7]
//left = 2, right = 4
//dq -> 4 
//ans -> 3, 3, 5