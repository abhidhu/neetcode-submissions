class PrefixTree {
    private PrefixTree[] tree = new PrefixTree[26];
    private boolean isEnd=false;
    public PrefixTree() {
         
    }

    public void insert(String word) {
        insert(0, word);
    }
    protected void insert(int i, String word){
        if(i==word.length()) {
            isEnd=true;
            return;
        }
        char c = word.charAt(i);
        if(tree[c-'a']==null){
            tree[c-'a']=new PrefixTree();
        }
        tree[c-'a'].insert(i+1, word);
    }

    public boolean search(String word) {
        return search(0, word, false);
    }

    protected boolean search(int i, String word, boolean flag){
        if(i==word.length()) return flag || isEnd;
        if(this.tree[word.charAt(i)-'a']==null){
            return false;
        }
        return this.tree[word.charAt(i)-'a'].search(i+1, word, flag);
    }


    public boolean startsWith(String prefix) {
        return search(0, prefix, true);
    }


}
