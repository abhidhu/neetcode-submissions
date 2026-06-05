class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
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
            if(j>i&&candidates[j]==candidates[j-1]){
                continue;
            }
            temp.addLast(candidates[j]);
            helper(candidates, target, j+1, ans, sum+candidates[j], temp);
            temp.removeLast();
        }
    }
}