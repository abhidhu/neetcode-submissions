class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, nums, ans);
        return ans;
    }
    private void helper(int i, int[] temp, List<List<Integer>> ans){
        if(i==temp.length){
            List<Integer> list = new ArrayList<>(temp.length);
            for(int j: temp) list.add(j);
            ans.add(list);
        }
        for(int j=i; j<temp.length;j++){
            int val = temp[i];
            temp[i]=temp[j];
            temp[j]=val;
            helper(i+1, temp, ans);
            val = temp[i];
            temp[i]=temp[j];
            temp[j]=val;
        }
    }
}