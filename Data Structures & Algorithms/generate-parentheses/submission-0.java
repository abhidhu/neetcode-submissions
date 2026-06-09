class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, 0, 0, "", ans);
        return ans;
    }
    private void helper(int n, int open, int close, String str, List<String> ans){
        if(n==open && open == close){
            ans.add(str);
            return;
        }
        //first choise
        if(open<n){
            helper(n, open+1, close, str+"(", ans);
        }
        if(close<open){
            helper(n, open, close+1, str+")", ans);
        }
    }
}