class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();

        for(int i=0; i<board.length;i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(!checkSudoku(i, j, i, board, rowMap)){
                    return false;
                }
                if(!checkSudoku(i, j, j, board, colMap)){
                    return false;
                }
                int temp = (int) (i/3) * 3 + j/3;
                if(!checkSudoku(i, j, temp, board, boxMap)){
                    return false;
                }
            }   
        }
        return true;
    }

    private boolean checkSudoku(int i, int j, int setNo,  char[][] board, Map<Integer, Set<Character>> map){
         Set<Character> set = map.get(setNo);
                if(set == null){
                    set = new HashSet<>();
                }
                else{
                    if(set.contains(board[i][j])){
                        return false;
                    }
                }
                set.add(board[i][j]);
                map.put(setNo, set);
                return true;
    }
}
