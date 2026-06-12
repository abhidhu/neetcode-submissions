class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans= new ArrayList<>();
        helper(n, new String[n][n], 0, ans);
        return ans;
    }

    private void helper(int n, String[][] board, int i, List<List<String>> ans){
        if(i==n){
            //record the answer
            recordAnswer(board, ans, n);
            return;
        }
        for(int j=0; j<n;j++){
            if(!(board[i][j] == null || board[i][j].isBlank())){
                continue;
            }
            //place the queen
            board[i][j]="Q";
            //mark all the possitions which can be atatcked by queen
            markBoard(board, i, j, n, true);
            helper(n, board, i+1, ans);//recursion
            markBoard(board, i, j, n, false);
            //remove the queen 
            board[i][j]=null;
        }
    }
    private void recordAnswer(String[][] board, List<List<String>> ans, int n){
        List<String> temp= new ArrayList<>();
        String str = "";
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                if(board[i][j]==null || !board[i][j].equals("Q")){
                    str+=".";
                }else{
                    str+="Q";
                }
            }
            temp.add(str);
            str="";
        }
        ans.add(temp);
    }
    private void markBoard(String[][] board, int i, int j, int n, boolean isMark){
        for(int temp=i+1;temp<n;temp++){
            if (isMark) {
                markHelper(board, temp, j);
            }else{
                unMarkHelper(board, temp, j);
            }
        }
        int tempi=i+1;
        int tempj=j+1;
        while(tempi<n && tempj<n){
            if (isMark){
                markHelper(board, tempi++, tempj++);
            }else{
                unMarkHelper(board, tempi++, tempj++);
            }
        }

        tempi=i+1;
        tempj=j-1;
        while(tempi<n && tempj>=0){
            if (isMark){
                markHelper(board, tempi++, tempj--);
            }else{
                unMarkHelper(board, tempi++, tempj--);
            }
        }
    }
    private void markHelper(String board[][], int i, int j){
        board[i][j]=board[i][j]!=null? board[i][j]+"*" : "*";
    }
    private void unMarkHelper(String board[][], int i, int j){
        board[i][j]=board[i][j]!=null && !board[i][j].isBlank()? board[i][j].substring(0, board[i][j].length()-1):null;
        if(board[i][j] !=null && board[i][j].isBlank()) board[i][j]=null;
    }
}