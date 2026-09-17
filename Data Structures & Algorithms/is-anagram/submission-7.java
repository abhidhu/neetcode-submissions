class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(c1 != c2){
                arr[c1-'a']++;
                arr[c2-'a']--;
            }
        }
        for(int i: arr){
            if(i != 0){
                return false;
            }
        }
        return true;
    }
}
