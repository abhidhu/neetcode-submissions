class Solution {
     public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    helper(i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void helper(int i, int j, char[][] grid){
        if(i<0 || j< 0 || i==grid.length || j==grid[i].length) {
            return;
        }
        if(grid[i][j]=='0' || grid[i][j]=='2') {
            return;
        }
        grid[i][j]='2';//marking visited

        helper(i+1, j, grid);
        helper(i-1, j, grid);
        helper(i, j-1, grid);
        helper(i, j+1, grid);
        return;
    }
}