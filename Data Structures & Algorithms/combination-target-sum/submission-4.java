class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, target, 0, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int[] nums, int i, int target, int sum, List<List<Integer>> ans, List<Integer> list){
        if(i >= nums.length || target <= sum) {
            if(target == sum ){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        
        //skip current index
        helper(nums, i+1, target, sum, ans, list);
        //include
        if(target >= sum + nums[i]) {
            list.add(nums[i]);
            helper(nums, i, target, sum + nums[i],ans, list);
            //remove the added one using backtracking
            list.removeLast();
        }
        return;
    }
}
