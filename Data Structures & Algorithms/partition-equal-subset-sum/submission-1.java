class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int target = sum/2;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int i=0;i<nums.length;i++){
            Set<Integer> temp = new HashSet<>();
            int num = nums[i];
            for(int val : set){
                int s = val+num;
                if(!set.contains(s)){
                    if(s==target) {
                        return true;
                    }
                    temp.add(s);
                }
            }
            set.addAll(temp);
        }
        return set.contains(target);
    }
}

