class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if(heights== null || heights.length==0) return ans;

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];
        // call for pacific ocean
        for(int i=0; i<heights.length;i++){
            helper(-1, heights, i, 0, pacific);
            helper(-1, heights, i, heights[i].length-1, atlantic);
        }

        for(int i=0; i<heights[0].length;i++){
            helper(-1, heights, 0, i, pacific);
             helper(-1, heights, heights.length-1, i, atlantic);
        }

        for(int i=0; i<heights.length;i++ ){
            for(int j=0; j< heights[i].length; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>(2);
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
    private void helper(int num, int[][] nums, int i, int j, boolean[][] arr){
        if(i<0 || j<0 || i==nums.length || nums[i].length==j || arr[i][j] || num>nums[i][j]){
            return;
        }
        
        arr[i][j]=true;
        // call recursion for all for direction
        helper(nums[i][j], nums, i+1, j, arr);
        helper(nums[i][j], nums, i-1, j, arr);
        helper(nums[i][j], nums, i, j+1, arr);
        helper(nums[i][j], nums, i, j-1, arr);
    }
}