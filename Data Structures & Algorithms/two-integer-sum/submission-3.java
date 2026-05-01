class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i< nums.length;i++){
            List<Integer> temp = map.getOrDefault(nums[i], new ArrayList<>());
            temp.add(i);
            map.put(nums[i], temp);
        }
        for(int i=0; i< nums.length;i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                List<Integer> list = map.get(temp);

                if(!list.isEmpty() && list.getFirst() != i){
                    return new int[]{i, map.get(temp).getFirst()};
                }
                else if(list.size() > 1){
                    list.removeFirst();
                    return new int[]{i, map.get(temp).getFirst()};
                }
            }
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
