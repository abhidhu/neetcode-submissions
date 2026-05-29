class Solution{
  public List<String> findWords(char[][] board, String[] words){
    List<String> ans = new ArrayList<>();
    Trie trie = new Trie();
    for(int i=0; i<words.length;i++){
      trie.insert(words[i]);
    }
    for(int i=0; i<board.length;i++){
      for(int j=0; j<board[i].length;j++){
        dfs(board, i, j, trie, ans);
      }
    }
    return ans;
  }
  private void dfs(char[][] board, int i, int j, Trie node, List<String> ans){
    //check does i and j are inside the board
    if(i<0 || j< 0 || i>=board.length || j >= board[i].length){
      return;
    }
    //check is valid word or not
    char c = board[i][j];
    if(c=='#'){
      return;
    }
    if(node.children[c-'a']==null){
      return;
    }
    if(node.children[c-'a'].word != null){ //valid one
      ans.add(node.children[c-'a'].word);
      node.children[c-'a'].word = null;  
    }
    board[i][j]='#';
    dfs(board, i+1, j, node.children[c-'a'], ans);
    dfs(board, i-1, j, node.children[c-'a'], ans);
    dfs(board, i, j-1, node.children[c-'a'], ans);
    dfs(board, i, j+1, node.children[c-'a'], ans);
    board[i][j]=c;
  } 
}



class Trie{
  public String word = null;
  public Trie[] children = new Trie[26];
  public boolean isEnd = false;
  public Trie(){
    children = new Trie[26];
    isEnd = false;
  }
  
  public void insert(String word){
    insertHelper(word, 0);
  }
  
  private void insertHelper(String word, int i){
    if(i==word.length()){
      this.isEnd = true;
      this.word = word;
      return;
    }
    char c = word.charAt(i);
    if(children[c-'a']==null){
      children[c-'a']=new Trie();
    }
    children[c-'a'].insertHelper(word, i+1);
  }
}