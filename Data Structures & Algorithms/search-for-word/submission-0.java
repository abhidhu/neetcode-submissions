class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length; j++){
               if (helper(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }
    private boolean helper(int i, int j, int k, char[][] board, String word){
        if(i< 0 || j< 0 ||board.length==i || board[i].length==j || board[i][j]=='#'){
            return false;
        }
        if(board[i][j] != word.charAt(k)){
            return false;
        }
        if(k==word.length()-1){
            return true;
        }

        char c = board[i][j];
        board[i][j]='#'; //mark visited
        if (helper(i, j+1, k+1, board, word)) return true;
        if (helper(i, j-1, k+1, board, word)) return true;
        if (helper(i+1, j, k+1, board, word)) return true;
        if (helper(i-1, j, k+1, board, word)) return true;
        board[i][j]=c;
        return false;
    }
}