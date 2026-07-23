class Solution {
    public String longestPalindrome(String s) {
       int n = s.length();
       int[] ans = new int[2];
       int size = 0;
       for(int i=0;i<n-1;i++){
         int[] even = helper(s, i, i);
         int[] odd = helper(s, i, i+1);
         //find the size and if it is greater than existing then update the ans
         if(even[1]-even[0]>ans[1]-ans[0]){
            ans=even;
         }
         if(odd[1]-odd[0]>ans[1]-ans[0]){
            ans=odd;
         }
       }
       return s.substring(ans[0], ans[1]+1);
    }

    private int[] helper(String s, int i, int j){
        int[] ans = new int[2];
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)){
            ans[0]=i--;
            ans[1]=j++;
        }
        return ans;

    }
}