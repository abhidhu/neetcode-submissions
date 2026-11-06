class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>  ans = new ArrayList<>();
        helper(0, new int[n][n], ans, n);
        return ans;
    }

    private void helper(int i, int[][] arr, List<List<String>> ans, int n) {
        // if(i<0 || j<0 || i >=n || j >= n) {//i<0 and j<0 is not needed but added as i practice this 
        //     return;
        // }
        if(i==n){
            //mark the ans
            ans.add(takeOutput(arr));
            return;
        }

        for(int j=0; j<n; j++){
            if(arr[i][j] == 0){
                //we can place here queen
                arr[i][j]=-1;
                helperMarking(i, j, arr, n);
                helper(i+1, arr, ans, n);
                helperUnMarking(i, j, arr, n);
                arr[i][j]=0; //backtracking remove the queen
            }
        }
    }

    private void helperUnMarking(int i, int j, int[][] arr, int n){
        unMarkVerticle(arr, i+1, j, n);
        unMarkDiagonalRight(arr, i+1, j+1, n);
        unMarkDiagonalLeft(arr, i+1, j-1, n);
    }

    private void helperMarking(int i, int j, int[][] arr, int n){
        markVerticle(arr, i+1, j, n);
        markDiagonalRight(arr, i+1, j+1, n);
        markDiagonalLeft(arr, i+1, j-1, n);
    }
    private void markVerticle(int[][] arr, int i, int j, int n){
        while(i<n && j<n){
            arr[i++][j]++;
        }
    }

    private void markDiagonalRight(int[][] arr, int i, int j, int n){
        while(i<n && j<n) {
            arr[i++][j++]++;
        }
    }

    private void markDiagonalLeft(int[][] arr, int i, int j, int n){
        while(i<n && j>=0) {
            arr[i++][j--]++;
        }
    }

    private void unMarkVerticle(int[][] arr, int i, int j, int n){
        while(i<n && j<n){
            arr[i++][j]--;
        }
    }

    private void unMarkDiagonalRight(int[][] arr, int i, int j, int n){
        while(i<n && j<n) {
            arr[i++][j++]--;
        }
    }

    private void unMarkDiagonalLeft(int[][] arr, int i, int j, int n){
        while(i<n && j>=0) {
            arr[i++][j--]--;
        }
    }

    private List<String> takeOutput(int[][] arr){
        List<String> list = new ArrayList<>();
        for(int i=0; i<arr.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<arr.length; j++) {
                if(arr[i][j]==-1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }
        return list;
    }
}