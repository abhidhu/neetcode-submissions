class Solution {
      public void islandsAndTreasure(int[][] grid) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        //first add all treasure in the queue
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[i].length;j++){
                if(grid[i][j]==0){
                    //add to the queue
                    int[] temp = new int[2];
                    temp[0]=i;
                    temp[1]=j;
                    dq.offerLast(temp);
                }
            }
        }
        int ans=1;

        //now lets run the loop to add the real values
        while(!dq.isEmpty()){
            int i=dq.size();
            while(i>0){
                i--;
                //take the element out and add the value
                int[] temp = dq.pollFirst();
                //check all the 4 side of it and add the value to it 
                helper(temp[0]+1, temp[1], grid, ans, dq);
                helper(temp[0]-1, temp[1], grid, ans, dq);
                helper(temp[0], temp[1]+1, grid, ans, dq);
                helper(temp[0], temp[1]-1, grid, ans, dq);
            }
            ans++;
        }
      }

      private void helper(int i, int j, int[][] grid, int ans, ArrayDeque<int[]> dq){
        if(i<0 || j<0 || i==grid.length || j==grid[i].length || grid[i][j]!=2147483647){
            return;
        }
        grid[i][j]=ans;
        int[] temp = new int[2];
        temp[0]=i;
        temp[1]=j;
        dq.offerLast(temp);
      }
  }