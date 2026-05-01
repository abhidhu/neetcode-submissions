class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //Native solution
        // Map<Integer, Integer> map = new HashMap<>();
        // for(Integer i: nums){
        //     map.put(i, map.getOrDefault(i, 0)+1);
        // }

        // List<Integer> list = map.keySet().stream().sorted((a, b) -> map.get(b)-map.get(a)).collect(Collectors.toList());

        // list = list.subList(0, k);
        // int[] ans = new int[list.size()];
        // int j = 0;
        // for(Integer i : list){
        //     ans[j++]=i;
        // }
        // return ans;

        //Solution 2 after practice
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<List<Integer>> list = new ArrayList<>(nums.length+1);
        for(int i=0; i<nums.length+1;i++){
            list.add(new ArrayList<>());
        }
        for(Integer i : map.keySet()){
            Integer temp = map.get(i);
            if(list.get(temp) == null){
                list.add(temp, new ArrayList<>());
                list.get(temp).add(i);
            }
            else{
                List<Integer> t = list.get(temp);
                t.add(i);
            }
        }
        int[] ans = new int[k];
        Collections.reverse(list);
        for(List<Integer> l : list){
            if(l != null && l.size() > 0){
                for(Integer i: l){
                    if(k<=0){
                        break;
                    }
                    ans[--k]=i;
                }
            }
        }
        return ans;
    }
}
