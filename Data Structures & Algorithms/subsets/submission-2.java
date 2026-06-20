class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    helper(nums, ans, new ArrayList<>(), 0);
    return ans;
  }
  private void helper(int[] nums, List<List<Integer>> ans, List<Integer> temp, int i){
    if(i==nums.length){
      ans.add(new ArrayList<>(temp));
      return;
    }
    // we have 2 choise, include or exclude
    //exclude
    helper(nums, ans, temp, i+1);
    //include
    temp.add(nums[i]);
    helper(nums, ans, temp, i+1);
    //once complete remove the included because we will use same array in every place
    temp.removeLast();
  }
}