class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length;i++){
            int temp = target - nums[i];
           if(map.containsKey(temp))
            return new int[]{map.get(temp), i};

            map.put(nums[i], i);
        }
        return new int[]{-1, -1};






























        // for(int i=0; i< nums.length-1;i++){
        //     for(int j=i+1; j<nums.length;j++){
        //         if(nums[i]+nums[j] == target){
        //             int[] ans = {i,j};
        //             return ans;
        //         }
        //     }
        // }
        // return new int[0];

        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i =0; i<nums.length; i++){
        //     int temp = target - nums[i];
        //     if(map.containsKey(temp)){
                
        //         int[] ans = {map.get(temp), i};
        //         return ans;
        //     }
        //     map.put(nums[i], i);
        // }
        // return new int[0];
    }
}
