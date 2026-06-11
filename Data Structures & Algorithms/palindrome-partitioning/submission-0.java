class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(s, ans, 0, new ArrayList<>());
        return ans;
    }

    private void helper(String s, List<List<String>> ans, int i, List<String> list){
        if(i==s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int j=i; j<s.length();j++){
            String sub = s.substring(i,j+1);
            if(isPalindrome(sub)){
                list.add(sub);
                helper(s, ans, j+1, list);
                list.removeLast();
            }
        }
    }
    private boolean isPalindrome(String s){
        for(int i=0; i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}

//"abcd"  i=0, j=0  -> substring(0,0) umm umm  to take 'a' we need substring(0,1)
