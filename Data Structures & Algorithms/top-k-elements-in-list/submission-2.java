class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(Integer i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<Integer> list = map.keySet().stream().sorted((a, b) -> map.get(b)-map.get(a)).collect(Collectors.toList());

        list = list.subList(0, k);
        int[] ans = new int[list.size()];
        int j = 0;
        for(Integer i : list){
            ans[j++]=i;
        }
        return ans;
    }
}
