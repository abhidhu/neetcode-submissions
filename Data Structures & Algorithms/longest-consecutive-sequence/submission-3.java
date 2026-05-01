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
      int ans = 1;
      int count=1;
      for(int i=0; i<nums.length;i++){
        if(!set.contains(nums[i] -1 )){
            continue;
        }
        int temp = nums[i];
        while(true){
            if(set.contains(++temp)){
                count++;
            }
            else{
                count++;
                if(count > ans){
                    ans = count;
                }
                 count = 1;
                 break;
            }
        }
      }
      return ans;
    }
}
