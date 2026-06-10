class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void helper(int[] nums, int i, List<Integer> temp, List<List<Integer>> ans){
        if(i==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        //ignore current
        helper(nums, i+1, temp, ans);
        //add current
        temp.add(nums[i]);
        helper(nums, i+1, temp, ans);
        temp.removeLast();
    }
}