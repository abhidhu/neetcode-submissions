class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>(), ans );
        return ans;
    }
    private void helper(int[] nums, int target, int sum, int i, List<Integer> temp, List<List<Integer>> ans){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
        }
        if(sum>=target) return;

        for(int j=i; j<nums.length;j++){
            if(j>i && nums[j]==nums[j-1]){
                continue;
            }
            if(target<sum+nums[j]) break;
            temp.add(nums[j]);
            helper(nums, target, sum + nums[j], j+1, temp, ans );
            temp.removeLast();
        }
    }
}