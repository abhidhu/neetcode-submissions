class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        else if(nums.length == 1){
            return 1;
        }
      Set<Integer> set = new HashSet<>(nums.length);
      for(int i=0; i< nums.length; i++){
        set.add(nums[i]);
      }
      int ans = 0;
      for(int i=0; i<nums.length;i++){
        if(set.contains(nums[i] -1 )){
            continue;
        }
        int temp = nums[i];
        int count = 1;
        while(set.contains(temp + 1)){
            count ++;
            temp ++;
        }
        ans = Math.max(ans, count);
      }
      return ans;
    }
}
