class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(   (a,b)-> grid[a[0]][a[1]] - grid[b[0]][b[1]]    );
        //add starting point , 0,0
        pq.offer(new int[2]);
        int ans=0;
        while(!pq.isEmpty()){
            int[] point = pq.poll();
            
            int i=point[0];
            int j=point[1];
            if( visited[i][j]) continue;
            visited[i][j]=true;
            ans = Math.max(ans, grid[i][j]);
            if(i==n-1 && j==n-1){
                break;
            }
            //get all for direction and check array index out of bound
            helper(i+1, j, visited, grid, n, pq);
            helper(i-1, j, visited, grid, n, pq);
            helper(i, j-1, visited, grid, n, pq);
            helper(i, j+1, visited, grid, n, pq);
        }
        return ans;
    }
    private void helper(int i, int j, boolean[][] visited, int[][] grid, int n, PriorityQueue<int[]> pq){
        if(i<0 || j<0 || i==n || j==n ){
            return;
        }
        int[] point = new int[2];
        point[0]=i;
        point[1]=j;
        pq.offer(point);
    }
}