class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length == 0) return 0;
        int ans=0;
        //first add all rotated oranges in queue
        Deque<int[]> q = new ArrayDeque<>();
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.offerLast(createArray(i, j));
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int i=0; i<size; i++){
                int[] temp = q.pollFirst();
                //check all possible side and make them roateded
                if (helper(q, temp[0]-1, temp[1], grid)) flag=true;;
                if (helper(q, temp[0]+1, temp[1], grid)) flag=true;
                if (helper(q, temp[0], 1+temp[1], grid)) flag=true;
                if (helper(q, temp[0], temp[1]-1, grid)) flag = true;
            }
            if (flag){
                 ans++;
            }   
        }

        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[i].length;j++){
                if(grid[i][j]==1){
                   return -1;
                }
            }
        }
        return ans;
    }
    private boolean  helper(Deque<int[]> q, int i, int j, int[][] grid){
        if(i<0 || j<0 || i == grid.length || j == grid[i].length){
            return false;
        }
        if(grid[i][j]==1){
            grid[i][j]=2;
            q.offerLast(createArray(i, j));
            return true;
        }
        return false;
    }
    private int[] createArray(int i, int j){
        int[] temp= new int[2];
        temp[0]=i;
        temp[1]=j;
        return temp;
    }
}