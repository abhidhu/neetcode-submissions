class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }
    
    private void helper(int[] nums, int i, List<List<Integer>> ans){
        if(i==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int j=0; j<nums.length;j++) temp.add(nums[j]);
            ans.add(temp);
            return;
        }
        for(int j=i; j<nums.length;j++){
            //swap
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            helper(nums, i+1, ans);
            //swap back
            temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
}