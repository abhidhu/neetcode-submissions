class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<nums.length-2;i++){
            int target = -nums[i];
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                if(nums[left] + nums[right] == target){
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[left]);
                    l.add(nums[right]);
                    ans.add(l);
                    left++;
                    right--;
                while(left < right && nums[left] == nums[left-1]) left++;
                while(left < right && nums[right] == nums[right+1]) right--;  
                }
                else if(nums[left] + nums[right] > target){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return ans;
    }
}
