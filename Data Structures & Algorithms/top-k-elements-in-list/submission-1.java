class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // List<Integer> sortedKeys =  map.keySet().stream()
        // .sorted((a,b) -> map.get(b) - map.get(a))
        // .collect(Collectors.toList());
        // sortedKeys = sortedKeys.subList(sortedKeys.size() - k, sortedKeys.size());
        // int[] ans = new int[sortedKeys.size()];
        // int j=0;
        // for(Integer i : sortedKeys){
        //     ans[j++]=i;
        // }
        // return ans;

       // 2. Sort the KEYS based on their values (frequencies)
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a, b) -> map.get(b) - map.get(a));

        // 3. Take the first k keys
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = keys.get(i);
        }
        
        return ans;
    }
}
