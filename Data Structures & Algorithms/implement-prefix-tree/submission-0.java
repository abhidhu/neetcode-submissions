class PrefixTree  {
    private PrefixTree [] carr = new PrefixTree [26];
    private boolean isEnd=false;
    public PrefixTree () {
        
    }
    
    public void insert(String word) {
        if(word==null || word.isBlank() || word.length()==0){
            return;
        }
        word = word.trim().toLowerCase();
        addCharacter(0,word);
    }
    private void addCharacter(int i, String word){
        char c = word.charAt(i);
        if(this.carr[c-'a']==null){
            this.carr[c-'a'] = new PrefixTree ();
        }
        if(i==word.length()-1){
            this.carr[c-'a'].isEnd = true;
            return;
        }
        this.carr[c-'a'].addCharacter(i+1, word);
    }

    
    public boolean search(String word) {
        if(word==null || word.isBlank() || word.length()==0){
            return false;
        }
        return searchWithIndex(0, word, false);
    }
    private boolean searchWithIndex(int i, String word, boolean isStartWith){
        char c = word.charAt(i);
        if(this.carr[c-'a'] == null) return false;
        if(i == word.length()-1) return isStartWith || this.carr[c-'a'].isEnd;
        return this.carr[c-'a'].searchWithIndex(i+1, word, isStartWith);
    }
    
    public boolean startsWith(String prefix) {
        return searchWithIndex(0, prefix, true);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */