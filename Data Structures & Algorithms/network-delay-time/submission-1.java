class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean[] visited = new boolean[n+1];
        int[] minDis = new int[n+1];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        for(int i=0; i<times.length;i++){
            int[] time = times[i];
            if(!map.containsKey(time[0])){
                map.put(time[0], new HashMap<>());
            }
            Map<Integer, Integer> m = map.get(time[0]);
            m.put(time[1], time[2]);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.offer(populateArray(k, 0));
        for(int i=1; i<minDis.length;i++){
            minDis[i]=Integer.MAX_VALUE;
        }
        minDis[k]=0;
        //start the Dijkstras algorithem
        while(!pq.isEmpty()){
            int[] time = pq.poll();
            if(visited[time[0]]){
                continue;
            }
            visited[time[0]]=true;
            Map<Integer, Integer> m1 = map.get(time[0]);
            if(m1==null ) continue;
            for(int i: m1.keySet()){
                int d = m1.get(i);
                int total = d+time[1];
                if(minDis[i]>total){
                    minDis[i]=total;
                    pq.offer(populateArray(i, total));
                }
            }
        }
        int ans=0;
        for(int i=1; i<visited.length;i++){
            if(!visited[i]) return -1;
            ans = Math.max(ans, minDis[i]);
        }
        return ans;
    }

    private int[] populateArray(int x, int y){
        int[] arr =new int[2];
        arr[0]=x;
        arr[1]=y;
        return arr;
    }
}