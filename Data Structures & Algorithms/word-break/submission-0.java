class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        return helper(0, new Boolean[n], s, new HashSet<>(wordDict), n);
    }


    private boolean helper(int i, Boolean[] cache, String s, Set<String> wordDict, int n){ 
        if(i==n) return true;//array index out bound exception can be accure

        if(cache[i] != null) {
            return cache[i];//return cached result dont calculate the things again
        }

        for(int j=i+1; j<=n;j++){
            String piece = s.substring(i,j);
            if(wordDict.contains(piece) && helper(j, cache, s, wordDict, n)){
                cache[i]=true;
                return true;
            }
        }
        cache[i]=false;
        return false;
    }
}