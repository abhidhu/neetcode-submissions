class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    private void helper(int i, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        // branch 1: include nums[i]
        temp.add(nums[i]);
        helper(i + 1, nums, temp, ans);
        temp.remove(temp.size() - 1);

        // branch 2: skip — but skip ALL duplicates of nums[i]
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        helper(i + 1, nums, temp, ans);
    }
}