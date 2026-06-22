class Solution {
    public int countComponents(int n, int[][] edges) {
        boolean[] arr = new boolean[n];
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int i=0; i<edges.length;i++){
            map.computeIfAbsent(edges[i][0], k-> new HashSet<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], k-> new HashSet<>()).add(edges[i][0]);
        }
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<n;i++){
            set.add(i);
        }
        int ans=0;
        while(!set.isEmpty()){
            int num = set.stream().findFirst().get();
            helper(-1, num, map, set, arr);
            ans++;
        }
        return ans;
    }
    private void helper(int parent, int num, Map<Integer, Set<Integer>> map, Set<Integer> unVisited, boolean[] arr){
        if(arr[num]) return;
        arr[num]=true;
        unVisited.remove(num);
        for(int i: map.getOrDefault(num, new HashSet<>())){
            if(i==parent) continue;
            helper(num, i, map, unVisited, arr);
        }
    }
}
