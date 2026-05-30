class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Integer> que = new PriorityQueue<>((a,b)-> map.get(a)-map.get(b));
        for(int i: map.keySet()){
            que.add(i);
            if(que.size()==k+1){
                que.poll();
            }
        }
        int[] ans = new int[k];
        for(int i=0; i< k; i++){
            ans[i]=que.poll();
        }
        return ans;
    }
}