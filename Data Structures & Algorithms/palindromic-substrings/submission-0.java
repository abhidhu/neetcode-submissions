class Solution {
    public int countSubstrings(String s) {
        int ans=0;
        for(int i=0; i<s.length()-1;i++){
            ans+=helper(s, i, i);
            ans+=helper(s, i, i+1);
        }
        return ans+1;//added 1 because my loop never run on last element of the string it terminate before s.length()-1
    }
    private int helper(String s, int i, int j){
        int count=0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
}