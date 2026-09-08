class Solution {
    public void rotate(int[][] matrix) {
        
        //take the transport of the matrix 
        for(int i=0; i<matrix.length; i++){
            for(int j=i+1; j<matrix[0].length; j++){
                int temp  = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //now interchange columns 
        int col = matrix.length-1;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[i][col-j];
                matrix[i][col-j]=temp;
            }
        }
    }
}