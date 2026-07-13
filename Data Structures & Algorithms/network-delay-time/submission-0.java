class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited = new boolean[n+1];
        int[] minDis = new int[n+1];
        //now lets create virtices and edges map
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int i=1; i<minDis.length; i++){
            minDis[i]=Integer.MAX_VALUE;
            map.put(i, new HashMap<>());
        }
        minDis[k]=0;
        int ans=-1;
        //min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> minDis[a] - minDis[b]);
        pq.offer(k);


        //main map key is vertex, then its sub map key means other vertex that can be reached fromt there and thats value means distance

        //lets add values to the map
        for(int i=0; i<times.length;i++){
            int[] arr = times[i];
            Map<Integer, Integer> childMap = map.get(arr[0]);
            childMap.put(arr[1], arr[2]);
        }

        // now lets start to explre the PQ
        while(!pq.isEmpty()){
            int explored = pq.poll();
            if(visited[explored]){
                continue;
            }
            visited[explored]=true;
            ans = Math.max(ans, minDis[explored]);
            // take all the adjecents and explore them
            int exDis = minDis[explored];
            Map<Integer, Integer> map1 = map.get(explored);
            for(int i: map1.keySet()){
                int dis = map1.get(i);
                int total = dis+exDis;
                //now to reach i we have sort distance dis + exDis by greedy
                if(minDis[i] > (total)){
                    minDis[i]=total;
                    pq.offer(i);
                }
            }
        }
        for(int i=1; i<visited.length;i++){
            if(!visited[i]){
                return -1;
            }
        }
        return ans;
    }
}