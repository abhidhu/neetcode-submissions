class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Set<Integer> set = new HashSet<>(nums.length);
        for(int i=0; i< nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;








































        // if(nums == null || nums.length == 0 || nums.length ==1){
        //     return false;
        // }
        // Set<Integer> numSet = new HashSet<>();
        // for(int i =0; i< nums.length;i++){
        //     if(numSet.contains(nums[i])){
        //         return true;
        //     }
        //     numSet.add(nums[i]);
        // }
        // return false;
    }
}