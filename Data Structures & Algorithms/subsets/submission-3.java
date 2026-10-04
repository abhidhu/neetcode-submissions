class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, ans, 0, new ArrayList<>());
        return ans;
    }

    private void helper(int[] nums, List<List<Integer>> ans, int i, List<Integer> list){
      if(i >=nums.length){
        ans.add(new ArrayList<>(list));// o(N) time
        return;
      }
      // 1st choice do not include
      helper(nums, ans, i+1, list);
      //2nd choice include
      list.add(nums[i]);
      helper(nums, ans, i+1, list);
      //remve included so we can not mix things in recursion
      list.removeLast();
      return;
    }
}
