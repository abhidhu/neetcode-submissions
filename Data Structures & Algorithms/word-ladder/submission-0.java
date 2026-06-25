class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //create a set for input word to find fast
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Set<String> visited= new HashSet<>();
        visited.add(beginWord);
        //BFS to reach the end
        int ans=0;
        ArrayDeque<String> dq=new ArrayDeque<>();
        dq.offerLast(beginWord);
        while(!dq.isEmpty()){
            int i=dq.size();
            ans++;
            while(i>0){
                i--;
                String word=dq.pollFirst();
                for(int j=0; j<word.length(); j++){
                    for(int k='a'; k<='z';k++){
                        if(k==word.charAt(j)) continue;
                        String str = helper(word, j, (char)k);
                        if(visited.contains(str) || !set.contains(str)) continue;
                        visited.add(str);
                        if(str.equals(endWord)){
                            return ++ans;
                        }
                        dq.offerLast(str);
                    }
                }
            }

        }
        return 0;
    }

    //private method for change the character by 1 and return 
    private String helper(String word, int i, char c){
        char[] chars = word.toCharArray();
        chars[i]=c;
        return new String(chars);
    }
}