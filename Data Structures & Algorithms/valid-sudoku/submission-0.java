class Solution {
    public boolean isValidSudoku(char[][] board) {
      Map<Integer, Set<Integer>>  rowMap = new HashMap<>();
      Map<Integer, Set<Integer>>  columnMap = new HashMap<>();
      Map<Integer, Set<Integer>>  boxMap = new HashMap<>();

      for(int i=0;i<9;i++){
        rowMap.put(i, new HashSet<>());
        columnMap.put(i, new HashSet<>());
        boxMap.put(i, new HashSet<>());
      }
      for(int i=0; i<9;i++){
        for(int j=0;j<9;j++){
            if(board[i][j] == '.'){
                continue;
            }
            int value =-1;
            try{
                 value = Character.getNumericValue(board[i][j]);
            }catch(NumberFormatException e){
                
            }
            if(value == -1){
                continue;
            }
            Set<Integer> rowSet= rowMap.get(i);
            if(rowSet.contains(value)){
                return false;
            }
            Set<Integer> columnSet = columnMap.get(j);
            if(columnSet.contains(value)){
                return false;
            }

            int temp = (int)(i/3) * 3 + (int)(j/3);
            Set<Integer> boxSet = boxMap.get(temp);
            if(boxSet.contains(value)){
                return false;
            }
            rowSet.add(value);
            columnSet.add(value);
            boxSet.add(value);
        }
      }
      return true;
    }
}
