class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, candidates, 0, target, 0, new ArrayList<>());
        return ans;
    }

    private void helper(List<List<Integer>> ans, int[] candidates, int sum, int target, int i, List<Integer> list ){
        if(target < sum){
            return;
        }
        if(target==sum){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int j=i; j<candidates.length; j++){
            if(j>i && candidates[j] == candidates[j-1]){
                continue;
            }
            if((target >= sum + candidates[j]) ){
                list.add(candidates[j]);
                helper(ans, candidates, sum+candidates[j], target, j+1, list);
                list.removeLast();
            }
        }
    }
}
// 1,2,2,2,5
//