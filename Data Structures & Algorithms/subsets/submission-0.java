class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        subsetHelper(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    private void subsetHelper(int i, int[] nums, List<Integer> temp, List<List<Integer>> ans){
        ans.add(temp);
        if(i==nums.length){
            return;
        }
        for(int j=i; j<nums.length;j++){
            List<Integer> list = new ArrayList<>(temp);
            list.add(nums[j]);
            subsetHelper(j+1,nums, list, ans);
        }
    }
}