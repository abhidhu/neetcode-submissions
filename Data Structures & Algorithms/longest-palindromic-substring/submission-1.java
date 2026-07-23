class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
       int[] ans = new int[2];
       for(int i=0;i<n-1;i++){
         helper(s, i, i, ans);
         helper(s, i, i+1, ans);
       }
       return s.substring(ans[0], ans[1]+1);
    }

    private void helper(String s, int i, int j, int[] ans){
        int ans0=0;
        int ans1=0;
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            ans0=i--;
            ans1=j++;
        }
        if(ans1-ans0>ans[1]-ans[0]){
            ans[0]=ans0;
            ans[1]=ans1;
        }
    }
}