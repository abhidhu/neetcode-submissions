class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> ans = new ArrayList<>();
      Arrays.sort(candidates);
      helper(candidates, target, 0, new ArrayList<>(), ans, 0);
      return ans;
    }
    private void helper(int[] nums, int target, int sum, List<Integer> temp, List<List<Integer>> ans, int i){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
        }
        if(sum>=target) return;

        for(int j=i; j<nums.length;j++){
            if(nums[j]>target-sum) break;
            temp.add(nums[j]);
            helper(nums, target, sum+nums[j], temp, ans, j);
            temp.removeLast();
        }
    }
}