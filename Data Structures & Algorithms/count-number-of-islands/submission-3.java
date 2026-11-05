class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[i].length; j++){
                if(grid[i][j]=='1'){
                    ans++;
                    helper(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void helper(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != '1'){
            return;
        }
        grid[i][j]='2';
        //go all the 4 way
        helper(grid, i+1, j);
        helper(grid, i-1, j);
        helper(grid, i, 1+j);
        helper(grid, i, j-1);
        return;
    }
}