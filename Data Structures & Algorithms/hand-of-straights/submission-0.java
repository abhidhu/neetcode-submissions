class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: hand){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for(int i: list){
            // find is it start if yes then proceed
            int groups = map.get(i);
            if(groups==0){
                continue;
            }

            for(int j=0; j<groupSize; j++){
                int index = i+j;
                int aval = map.getOrDefault(index, 0);
                if(aval<groups){
                    return false;
                }
                map.put(index, aval-groups);
            }
        }
        return true;
    }
}
