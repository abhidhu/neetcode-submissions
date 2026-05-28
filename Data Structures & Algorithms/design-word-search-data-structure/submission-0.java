class WordDictionary {
    private WordDictionary[] wd = new WordDictionary[26];
    private boolean isEnd = false;
    public WordDictionary() {
        wd = new WordDictionary[26];
        isEnd = false;
    }
    
    public void addWord(String word) {
        this.addWordHelper(word, 0);
    }
    private void addWordHelper(String w, int i){
        if(this.wd[w.charAt(i)-'a']==null){
            this.wd[w.charAt(i)-'a']=new WordDictionary();
        }
        if(i==w.length()-1){
            this.wd[w.charAt(i)-'a'].isEnd=true;
            return;
        }
        this.wd[w.charAt(i)-'a'].addWordHelper(w, i+1);
    }
    
    public boolean search(String word) {
        return searchHelper(0, word);
    }
    private boolean searchHelper(int i, String w){
        if(i==w.length()){
            return false;
        }
        char c = w.charAt(i);
        if(c=='.'){//we dont know the this character so we will check does any non null exists and will iterate on it
          for(int j=0; j<26;j++){
            if(this.wd[j]==null){
                continue;
            }
            if(i==w.length()-1 && this.wd[j].isEnd) return true;
            if(i < w.length()-1 && this.wd[j].searchHelper(i+1, w)){
                return true;
            }
          }
          return false;
        }
        if(this.wd[c-'a'] == null || i==w.length()-1 && !this.wd[c-'a'].isEnd){
            return false;
        }
        if(this.wd[c-'a'].isEnd && i==w.length()-1){
            return true;
        }
        return this.wd[c-'a'].searchHelper(i+1, w);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */