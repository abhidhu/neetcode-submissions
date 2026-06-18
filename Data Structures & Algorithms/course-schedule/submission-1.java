class Solution {
    private Set<Integer> black;
    public boolean canFinish(int numCourses, int[][] pre) {
        this.black=new HashSet<>();
        //create map and add all the element in it as a path 
        Map<Integer, List<Integer>> map = new HashMap<>(numCourses);
        for(int i=0; i<pre.length;i++){
            map.computeIfAbsent(pre[i][0], k->new ArrayList<>()).add(pre[i][1]);
        }
        for(int i: map.keySet()){
           if (!helper(i, map, new HashSet<>())){
            return false;
           }
        }
        return true;
    }
    private boolean helper(int i, Map<Integer, List<Integer>> map, Set<Integer> set){
        if(black.contains(i) || !map.containsKey(i) || map.get(i)==null || map.get(i).isEmpty()){
            return true;
        }
        if(set.contains(i)) {
            return false;
        }
        for(int num: map.get(i)){
            set.add(i);
            if (!helper(num, map, set)) {
                return false;
            }
            set.remove(i);
        }
        this.black.add(i);
        return true;
    }
}