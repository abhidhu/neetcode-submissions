class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, candidates, target, 0, new ArrayList<>(), 0);
        return ans;
    }

    private void helper(List<List<Integer>> ans, int[] candi, int target, int sum, List<Integer> list, int i){
        if(target < sum){
            return;
        }
        if(target==sum) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int j=i; j<candi.length; j++){
            if(sum <= target){
                list.add(candi[j]);
                helper(ans, candi, target, sum+candi[j], list, j);
                list.removeLast();//can be used length - 1but java 21+ support this
            }
        }
    }
}