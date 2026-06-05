class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, ans, 0, new ArrayList<>());
        return ans;
    }
    private void helper(int[] candidates, int target, int i, List<List<Integer>> ans, int sum, List<Integer> temp){
        if(sum==target){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(i==candidates.length || sum>target){
            return;
        }
        for(int j=i; j<candidates.length;j++){
            temp.addLast(candidates[j]);
            helper(candidates, target, j, ans, sum+candidates[j], temp);
            temp.removeLast();
        }
    }
}