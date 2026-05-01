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

                if(!doSomething(i, j, i, board, rowMap)){
                    return false;
                }
                if(!doSomething(i, j, j, board, colMap)){
                    return false;
                }

                int temp = (int) (i/3) * 3 + j/3;

                if(!doSomething(i, j, temp, board, boxMap)){
                    return false;
                }
                // Set<Integer> rowSet = rowMap.get(i);
                // if(rowSet == null){
                //     rowSet = new HashSet<>();
                // }
                // else{
                //     if(rowSet.contains(board[i][j])){
                //         return false
                //     }
                // }
                // rowSet.add(board[i][j]);
                // map.put(i, rowSet);
            }   
        }
        return true;
    }

    private boolean doSomething(int i, int j, int setNo,  char[][] board, Map<Integer, Set<Character>> map){
         Set<Character> rowSet = map.get(setNo);
                if(rowSet == null){
                    rowSet = new HashSet<>();
                }
                else{
                    if(rowSet.contains(board[i][j])){
                        return false;
                    }
                }
                rowSet.add(board[i][j]);
                map.put(setNo, rowSet);
                return true;
    }








































    //   Map<Integer, Set<Integer>>  rowMap = new HashMap<>();
    //   Map<Integer, Set<Integer>>  columnMap = new HashMap<>();
    //   Map<Integer, Set<Integer>>  boxMap = new HashMap<>();

    //   for(int i=0;i<9;i++){
    //     rowMap.put(i, new HashSet<>());
    //     columnMap.put(i, new HashSet<>());
    //     boxMap.put(i, new HashSet<>());
    //   }
    //   for(int i=0; i<9;i++){
    //     for(int j=0;j<9;j++){
    //         if(board[i][j] == '.'){
    //             continue;
    //         }
    //         int value =-1;
    //         try{
    //              value = Character.getNumericValue(board[i][j]);
    //         }catch(NumberFormatException e){
                
    //         }
    //         if(value == -1){
    //             continue;
    //         }
    //         Set<Integer> rowSet= rowMap.get(i);
    //         if(rowSet.contains(value)){
    //             return false;
    //         }
    //         Set<Integer> columnSet = columnMap.get(j);
    //         if(columnSet.contains(value)){
    //             return false;
    //         }

    //         int temp = (int)(i/3) * 3 + (int)(j/3);
    //         Set<Integer> boxSet = boxMap.get(temp);
    //         if(boxSet.contains(value)){
    //             return false;
    //         }
    //         rowSet.add(value);
    //         columnSet.add(value);
    //         boxSet.add(value);
    //     }
    //   }
    //   return true;
    // }
}
