class Solution {
    public int minCostConnectPoints(int[][] points) {
        int ans=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        boolean[] visited=new boolean[points.length];
        pq.add(new int[2]);
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            if(visited[arr[0]]) continue;
            int x = arr[0];
            int y=arr[1];
            visited[x]=true;
            ans+=y;
            for(int i=0; i<visited.length;i++){
                if(visited[i]) continue;
                int dis = manhattanDistance(points[x], points[i]);
                int[] temp=new int[2];
                temp[0]=i;
                temp[1]=dis;
                pq.offer(temp);
            }
        }
        return ans;
    }

    private int manhattanDistance(int[] p, int[] q){
        return Math.abs(p[0]-q[0]) + Math.abs(p[1]-q[1]);
    }
}