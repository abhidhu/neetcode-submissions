class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = matrix.length*matrix[0].length-1;
        while(left <= right){
            int mid = (left + right)/2;
            int i=mid/n;
            int j = mid%n;
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] < target){
                left = mid + 1;
            }else{
                right = mid -1;
            }
        }
        return false;
    }
}
