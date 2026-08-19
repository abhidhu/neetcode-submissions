class Solution {
    public boolean canPartition(int[] nums) {
        int sum =0;
        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum /2;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        int n=nums.length;
        for(int i=n-1; i>=0; i--){
            Set<Integer> temp = new HashSet<>();
            int num = nums[i];
            for(int var : set){
                if(var+num == target){
                    return true;
                }else if(var + num < target){
                    temp.add(var+num);
                }
            }
            set.add(num);
            set.addAll(temp);
        }
        return false;
    }
}