class Solution {
    public boolean validTree(int n, int[][] edges) {
        //make boolean array for check visited or not
        boolean[] arr = new boolean[n];
        //now make graph which contains key as node and values as set of edge
        Map<Integer, Set<Integer>> map=new HashMap<>();
        for(int i=0; i<edges.length;i++){
            map.computeIfAbsent(edges[i][0], k-> new HashSet<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], k-> new HashSet<>()).add(edges[i][0]);
        }
        //now check does cycle exists
        if(helper(n-1,  -1, arr, map, new HashSet<>())) return false;
        for(boolean b : arr){
            if(!b) return false;
        }
        return true;
    }

    private boolean helper(int num, int parent, boolean[] arr, Map<Integer, Set<Integer>> map, Set<Integer> visited){
        if(visited.contains(num)){
            return true;
        }
        visited.add(num);
        arr[num]=true;
        //traverse on its edges
        for(int i: map.getOrDefault(num, new HashSet<>())){
            if(i==parent) continue;
            if (helper(i, num, arr, map, visited)) return true;
        }
        visited.remove(num);
        return false;
    }
}
