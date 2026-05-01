class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        if(nums.length==0){
            return new int[0];
        }
        int[] ans = new int[nums.length - k +1];
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            if(max < nums[i]){
                max = nums[i];
            }
            if(i-k>=0){
                int temp = map.get(nums[i-k]);
                if(temp==1){
                    map.remove(nums[i-k]);
                    if(nums[i-k] == max){
                        max = getMax(map.keySet());
                    }
                } else{
                    map.put(nums[i-k], map.get(nums[i-k]) -1 );
                }
            }
            if(i-k+1>=0){
                ans[i-k+1]=max;
            }
        }
        return ans;
        
    }
    private int getMax(Set<Integer> set){
        int ans =Integer.MIN_VALUE;
        for(Integer i : set){
            ans = Math.max(i, ans);
        }
        return ans;

    }
}
